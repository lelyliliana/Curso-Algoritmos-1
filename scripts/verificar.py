"""Ejecuta ejemplos aislados, contratos, casos de algoritmos y enlaces locales."""
from pathlib import Path
import json
import re
import shutil
import subprocess
import tempfile
ROOT=Path(__file__).resolve().parents[1]
JAVA=['java','-Dfile.encoding=UTF-8','-Dstdout.encoding=UTF-8','-Dstderr.encoding=UTF-8']

def proceso(comando,carpeta,entrada=''):
    p=subprocess.run(comando,cwd=carpeta,input=entrada,text=True,encoding='utf-8',capture_output=True,timeout=60)
    if p.returncode:
        raise AssertionError(f'{carpeta.name}: salida {p.returncode}\n{p.stdout}\n{p.stderr}')
    return p.stdout.replace('\r\n','\n')

def main():
    ejemplos=json.loads((ROOT/'scripts/ejemplos.json').read_text(encoding='utf-8'))
    for ejemplo in ejemplos:
        origen=ROOT/ejemplo['folder']
        esperado=(origen/'esperado.txt').read_text(encoding='utf-8')
        with tempfile.TemporaryDirectory(prefix='algoritmos-') as temporal:
            carpeta=Path(temporal)
            shutil.copy(origen/'Main.java',carpeta/'Main.java')
            obtenido=proceso([*JAVA,'Main.java'],carpeta,ejemplo['stdin'])
            if obtenido!=esperado:
                raise AssertionError(f"{ejemplo['folder']}\nEsperado:{esperado!r}\nObtenido:{obtenido!r}")
            if origen.name=='14-proyecto-integrador':
                verificado=proceso([*JAVA,'Main.java','--verificar'],carpeta)
                if verificado!='Verificación de catálogo y persistencia aprobada\n':
                    raise AssertionError('Verificación del proyecto incompleta')
                entrada='1\nK09\nJosé\n3\n1\nK09\nDuplicado\n8\n5\n6\n2\nK09\n3\nK09\n4\n0\n'
                menu=proceso([*JAVA,'Main.java','--interactivo'],carpeta,entrada)
                for texto in ['Alta registrada','Código duplicado','Guardado completo','Carga completa','José / 3','Eliminado','Registros: 0']:
                    if texto not in menu:raise AssertionError('Menú sin comportamiento: '+texto)
        print('OK '+ejemplo['folder'])
    casos=[('seleccion','unidad2/14-ordenamiento-por-seleccion','Selección: 5 casos aprobados\n'),
           ('producto','unidad2/20-producto-de-matrices','Producto: 4 casos aprobados\n'),
           ('busqueda','unidad3/09-busqueda-lineal-y-binaria','Búsqueda: 64 casos aprobados\n')]
    for nombre,leccion,esperado in casos:
        with tempfile.TemporaryDirectory(prefix='pruebas-algoritmos-') as temporal:
            carpeta=Path(temporal)
            shutil.copy(ROOT/leccion/'Main.java',carpeta/'Main.java')
            shutil.copy(ROOT/'tests'/nombre/'Prueba.java',carpeta/'Prueba.java')
            # El módulo del compilador está incluido en el JDK completo.
            proceso([*JAVA,'com.sun.tools.javac.Main','-encoding','UTF-8','-d','.', 'Main.java','Prueba.java'],carpeta)
            obtenido=proceso([*JAVA,'-cp','.','Prueba'],carpeta)
            if obtenido!=esperado:raise AssertionError('Comprobación incompleta: '+nombre)
            print(obtenido.strip())
    with tempfile.TemporaryDirectory(prefix='entrada-algoritmos-') as temporal:
        carpeta=Path(temporal)
        shutil.copy(ROOT/'unidad1/08-asignacion-y-entrada/Main.java',carpeta/'Main.java')
        for entrada,mensaje in [('0\n','Disponibles: 10'),('10\n','Disponibles: 0'),('11\n','Venta fuera de rango'),('-1\n','Venta fuera de rango'),('tres\n','Escribe un número entero')]:
            if mensaje not in proceso([*JAVA,'Main.java'],carpeta,entrada):raise AssertionError('Entrada incorrecta: '+entrada)
    enlaces=0
    for archivo in ROOT.rglob('*.md'):
        texto=archivo.read_text(encoding='utf-8')
        for destino in re.findall(r'\]\(([^)]+)\)',texto):
            if '://' in destino or destino.startswith(('#','mailto:')):continue
            ruta=destino.split('#',1)[0]
            if ruta and not (archivo.parent/ruta).resolve().exists():raise AssertionError(f'Enlace roto: {archivo}: {destino}')
            enlaces+=1
    print(f'{len(ejemplos)} ejemplos, 73 casos de algoritmos, contratos del catálogo, menú y entrada aprobados; {enlaces} enlaces locales válidos.')

if __name__=='__main__':main()

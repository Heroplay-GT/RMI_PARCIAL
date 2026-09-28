@echo off
setlocal
cd /d "%~dp0"
set PKG=com\parcial\promedio\rmi

echo [1/3] Compilando la libreria comun y generando el JAR...
if exist EjemploRmiLibPromedio\bin rmdir /s /q EjemploRmiLibPromedio\bin
javac -encoding UTF-8 -d EjemploRmiLibPromedio\bin EjemploRmiLibPromedio\src\%PKG%\lib\*.java || goto error
jar cf EjemploRmiLibPromedio\dist\EjemploRmiLibPromedio.jar -C EjemploRmiLibPromedio\bin . || goto error
copy /y EjemploRmiLibPromedio\dist\EjemploRmiLibPromedio.jar EjemploRmiServidorPromedio\lib\ >nul
copy /y EjemploRmiLibPromedio\dist\EjemploRmiLibPromedio.jar EjemploRmiClientePromedio\lib\ >nul

echo [2/3] Compilando el servidor...
if exist EjemploRmiServidorPromedio\bin rmdir /s /q EjemploRmiServidorPromedio\bin
javac -encoding UTF-8 -cp "EjemploRmiServidorPromedio\lib\*" -sourcepath EjemploRmiServidorPromedio\src -d EjemploRmiServidorPromedio\bin EjemploRmiServidorPromedio\src\%PKG%\Principal.java || goto error

echo [3/3] Compilando el cliente...
if exist EjemploRmiClientePromedio\bin rmdir /s /q EjemploRmiClientePromedio\bin
javac -encoding UTF-8 -cp "EjemploRmiClientePromedio\lib\*" -sourcepath EjemploRmiClientePromedio\src -d EjemploRmiClientePromedio\bin EjemploRmiClientePromedio\src\%PKG%\Principal.java || goto error

echo.
echo Compilacion exitosa. Ejecute ejecutar-servidor.bat y luego ejecutar-cliente.bat
goto fin
:error
echo.
echo *** ERROR DE COMPILACION ***
:fin
pause

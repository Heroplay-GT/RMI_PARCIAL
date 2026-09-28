@echo off
setlocal
cd /d "%~dp0"
set PKG=com\parcial\promedio\rmi

echo [1/3] Compilando la libreria comun y generando el JAR...
if exist EjemploLipeRmiLibPromedio\bin rmdir /s /q EjemploLipeRmiLibPromedio\bin
javac -encoding UTF-8 -d EjemploLipeRmiLibPromedio\bin EjemploLipeRmiLibPromedio\src\%PKG%\lib\*.java || goto error
jar cf EjemploLipeRmiLibPromedio\dist\EjemploLipeRmiLibPromedio.jar -C EjemploLipeRmiLibPromedio\bin . || goto error
copy /y EjemploLipeRmiLibPromedio\dist\EjemploLipeRmiLibPromedio.jar EjemploLipeRmiServidorPromedio\lib\ >nul
copy /y EjemploLipeRmiLibPromedio\dist\EjemploLipeRmiLibPromedio.jar EjemploLipeRmiClientePromedio\lib\ >nul

echo [2/3] Compilando el servidor...
if exist EjemploLipeRmiServidorPromedio\bin rmdir /s /q EjemploLipeRmiServidorPromedio\bin
javac -encoding UTF-8 -cp "EjemploLipeRmiServidorPromedio\lib\*" -sourcepath EjemploLipeRmiServidorPromedio\src -d EjemploLipeRmiServidorPromedio\bin EjemploLipeRmiServidorPromedio\src\%PKG%\Principal.java || goto error

echo [3/3] Compilando el cliente...
if exist EjemploLipeRmiClientePromedio\bin rmdir /s /q EjemploLipeRmiClientePromedio\bin
javac -encoding UTF-8 -cp "EjemploLipeRmiClientePromedio\lib\*" -sourcepath EjemploLipeRmiClientePromedio\src -d EjemploLipeRmiClientePromedio\bin EjemploLipeRmiClientePromedio\src\%PKG%\Principal.java || goto error

echo.
echo Compilacion exitosa. Ejecute ejecutar-servidor.bat y luego ejecutar-cliente.bat
goto fin
:error
echo.
echo *** ERROR DE COMPILACION ***
:fin
pause

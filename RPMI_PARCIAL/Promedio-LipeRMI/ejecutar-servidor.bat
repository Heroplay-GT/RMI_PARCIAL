@echo off
cd /d "%~dp0"
title Servidor Promedio (Promedio-LipeRMI)
java -cp "EjemploLipeRmiServidorPromedio\bin;EjemploLipeRmiServidorPromedio\lib\*" com.parcial.promedio.rmi.Principal
pause

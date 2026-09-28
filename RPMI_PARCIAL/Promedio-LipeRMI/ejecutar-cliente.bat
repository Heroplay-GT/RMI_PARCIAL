@echo off
cd /d "%~dp0"
title Cliente Promedio (Promedio-LipeRMI)
java -cp "EjemploLipeRmiClientePromedio\bin;EjemploLipeRmiClientePromedio\lib\*" com.parcial.promedio.rmi.Principal
pause

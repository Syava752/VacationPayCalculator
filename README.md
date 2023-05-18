# Neoflex-test-task-VacationPayCalculator
Тестовое задание для учебного центра Neoflex, 2023 
  
Приложение "Калькулятор отпускных".  
Микросервис на SpringBoot + Java 11 c одним API: GET "/calculacte"  
  
Приложение принимает твою среднюю зарплату за 12 месяцев и количество дней отпуска - отвечает суммой отпускных, которые придут сотруднику.  
Доп. задание: При запросе также можно указать точные дни ухода в отпуск, тогда должен проводиться рассчет отпускных с учётом праздников и выходных.
Также написаны юнит-тесты.

# Cтек проекта
SpringBoot  
Java 11     
jUnit  
Mockito

# API requests
Простой запрос:  
http://localhost:8080/calculate?salary=3150&days=28   
  
Запрос с указанием точного дня ухода в отпуск:  
http://localhost:8080/calculate?salary=3150&days=28&startDate=2023-01-01&endDate=2023-01-30

# Postman
Простой запрос:  
![image](https://github.com/Syava752/VacationPayCalculator/assets/109652027/80cab7c6-f2d1-4e67-8941-6fa91a57617d)

Запрос с указанием точного дня ухода в отпуск:  
![image](https://github.com/Syava752/VacationPayCalculator/assets/109652027/7d1eed5a-d000-4a17-b12a-5e3dba0a65dc)

# Структура проекта

- pages - Page Objects используемых страниц
- tests - ТЕСТЫ
- utils - Класс для считывания данных с файла aplication.properties
- pom.xml - Конфигурация сборщика Maven
- resources: 
     - allure.properties - файл для конфигурации отчета Allure
     - application.properties - файл для данных
     - log4j2 - файл для настроек логирования

# Тесты

- GoogleResultTest - Тесты проверки страницы с результатами
- GoogleSearchTest - Тесты проверки страницы поиска


# Инструкция по запуску тестов

---
- mvn clean test - Запуск всех тестов
- mvn clean test -Dtag=googleSearch - Запуск тестов Проверки страницы Google Поиска
- mvn clean test -Dtag=googleResult - Запуск тестов Проверки страницы Google Результата
- allure serve (Отображение отчетов в окне браузера)
---


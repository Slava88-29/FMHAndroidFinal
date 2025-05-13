# Приложение «Мобильный хоспис»

Инструкция по запуску автотестов для Android-приложения FMH

## ⚙️ Требования

Перед запуском тестов необходимо установить:

- Android Studio (последняя стабильная версия)

- Java JDK 11+

- Android SDK

- Устройство/эмулятор с Android 8.0+

## 🛠 Настройка проекта

1. Клонируйте репозиторий:

git clone <ссылка-на-репозиторий>

cd <название-папки-проекта>

2. Импортируйте проект в Android Studio:

File → Open → Выберите папку проекта

3. Настройте устройство:

Физическое устройство: включите режим разработчика и USB-отладку

Эмулятор: Tools → AVD Manager → Create Virtual Device (рекомендуется Pixel 4, API 28-33)

▶️ Запуск тестов

Все тесты:

./gradlew connectedAndroidTest

Конкретный класс тестов

./gradlew connectedAndroidTest -Pandroid.testInstrumentationRunnerArguments.class=ru.iteco.fmhandroid.ui.tests.НазваниеТестКласса

Через Android Studio:

Откройте вкладку "Project"

Перейдите в app/src/androidTest/java/ru/iteco/fmhandroid/ui/tests

Для запуска:

Всех тестов: ПКМ на папке tests → Run

Конкретного класса: ПКМ на классе → Run

Отдельного теста: ПКМ на методе → Run

ℹ️ Дополнительная информация

Структура тестов:

src/

androidTest/

    java/

      ru.iteco.fmhandroid/

        ui/

          steps/           # Шаги тестов

          screenElements/      # Экраны приложения

          tests/           # Тест-кейсы

          data/            # Тестовые данные
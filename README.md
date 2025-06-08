# Архитектура UI-тестов для Android приложения

## Обзор

Проект содержит автоматизированные UI-тесты для мобильного приложения, написанные на Java с использованием фреймворков **JUnit** и **Allure** для отчетности. Тесты покрывают ключевые функциональные модули: авторизацию, работу с новостями, страницу "О приложении" и раздел "Наша миссия".

---

## Ключевые компоненты

### 1. Базовый класс `BaseTest`

- **Назначение**: Инициализация общих ресурсов и правил тестирования.  
- **Функционал**:
  - `ActivityScenarioRule` для управления жизненным циклом `AppActivity`.
  - Общие экземпляры классов шагов (`AuthSteps`, `MainSteps` и др.).
  - Методы `verifyAuthScreen()` и `verifyMainScreen()` для предварительных проверок.

```java
@Rule
public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
    new ActivityScenarioRule<>(AppActivity.class);

protected AuthSteps authSteps = new AuthSteps();
```

---

### 2. Шаги (Steps)

- **Назначение**: Инкапсуляция действий пользователя и проверок.

**Примеры:**

- `AuthSteps`: Ввод логина/пароля, нажатие кнопок авторизации.
- `NewsSteps`: Создание, редактирование, удаление новостей.
- `AboutSteps`: Проверка элементов страницы "О приложении".

**Метод из `AuthSteps`:**

```java
public void enterLogin(String login) {
    element.authLoginInput.perform(replaceText(login));
}
```

---

### 3. Локаторы (ScreenElements)

- **Назначение**: Хранение локаторов для элементов интерфейса.

**Пример (`AboutScreenElements`):**

```java
public class AboutScreenElements {
    public ViewInteraction getVersionTitle() {
        return onView(withId(R.id.about_version_title));
    }
}
```

---

### 4. Утилиты (DataHelper)

- **Назначение**: Хранение тестовых данных и констант.

**Пример:**

```java
public static final String VALID_LOGIN = "login123";
public static final String ERROR_MSG_WRONG_CREDENTIALS = "Неверные учетные данные";
```

---

### 5. Тестовые классы

- **Назначение**: Реализация сценариев тестирования.

**Структура:**

- Аннотации Allure (`@Epic`, `@Feature`, `@Story`) для категоризации.
- Методы с `@Test`, `@Before`, и `@Description`.

**Пример теста (`AuthTest`):**

```java
@Test
@Story("Неуспешная авторизация")
@Description("Проверка входа с невалидным паролем")
public void authNoValidPasswordTest() {
    authSteps.enterLogin(VALID_LOGIN);
    authSteps.enterPassword(INVALID_PASSWORD);
    authSteps.clickSignInButton();
    authSteps.verifyErrorMessage(ERROR_MSG_WRONG_CREDENTIALS);
}
```

---

## Зависимости

Основные библиотеки:

- Java
- JUnit 4.13.2
- Allure
- Espresso
- AndroidX Test

---

## Запуск тестов

Тесты можно запускать через Android Studio или с помощью Gradle:

```bash
./gradlew connectedAndroidTest
```

Для генерации отчета Allure:

```bash
allure serve build/allure-results
```

---


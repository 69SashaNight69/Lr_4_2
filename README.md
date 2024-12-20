# CompletableFutureDemo

Цей проект демонструє використання різних методів класу `CompletableFuture` в Java, зокрема:

- `runAsync()`
- `supplyAsync()`
- `thenApplyAsync()`
- `thenAcceptAsync()`
- `thenRunAsync()`

Програма виконує серію асинхронних операцій, включаючи генерацію послідовності випадкових цілих чисел, обчислення мінімального та максимального значення для непарних та парних індексів, а також виведення результатів.

## Як працює код

1. **`runAsync()`**  
   Цей метод використовується для асинхронного виконання завдання без повернення результату. В нашій програмі він просто виводить повідомлення про запуск асинхронної програми.

2. **`supplyAsync()`**  
   Цей метод дозволяє асинхронно виконати завдання та повернути результат. У програмі він генерує послідовність із 20 випадкових чисел від 0 до 100, використовуючи клас `Random`.

3. **`thenApplyAsync()`**  
   Цей метод дозволяє застосовувати трансформацію до результату попереднього `CompletableFuture` асинхронно. В нашій програмі він обчислює мінімальне значення серед чисел на непарних індексах та максимальне значення серед чисел на парних індексах.

4. **`thenAcceptAsync()`**  
   Цей метод дозволяє виконати дію після завершення попереднього завдання асинхронно, при цьому результат попереднього завдання передається в дію. У програмі після обчислення мінімуму та максимуму, їх сума виводиться в консоль.

5. **`thenRunAsync()`**  
   Цей метод дозволяє виконати завдання після завершення попереднього без використання його результату. В нашій програмі він використовується для виведення повідомлення про завершення всіх асинхронних операцій.

## Висновки

Програма демонструє можливості класу `CompletableFuture` для виконання асинхронних операцій паралельно, що дозволяє ефективно обробляти завдання, не блокуючи основний потік виконання. Методи, що використовуються в програмі, дозволяють легко поєднувати різні асинхронні операції та працювати з результатами, виконуючи додаткові дії після їх завершення.

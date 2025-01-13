# bank_account

Розробити програму, яка моделює банківський рахунок, що має наступні атрибути, які повинні бути з захищеним доступом:

++ Баланс (тип float).//balance
++ Кількість поповнень з початковим значенням нуль (тип int).//numberOfDeposits
++ Кількість зняттів з початковим значенням нуль (тип int).//numberOfWithdrawals
++ Річна процентна ставка (тип float).//annualInterestRate
++ Місячна комісія з початковим значенням нуль (тип float).//monthlyFee
Клас "Рахунок" має:

++ Конструктор, що ініціалізує атрибути "баланс" та "річна ставка" значеннями, переданими як параметри.
Методи:
++ Поповнити рахунок: додає гроші до балансу.
++ Зняти гроші: оновлює баланс рахунку. Сума зняття не повинна перевищувати баланс.
++ Розрахувати місячний відсоток для рахунку та оновити відповідний баланс.
++ Місячна виписка: оновлює баланс, віднімаючи місячну комісію та розраховуючи відповідний місячний відсоток (викликає попередній метод).
++ Друк: повертає значення атрибутів.
Друк інформації: повертає значення всіх атрибутів.
Клас "Рахунок" має два дочірні класи:

1. Рахунок заощаджень
Додатковий атрибут:

Активність рахунку (тип boolean). Якщо баланс менший за 10 000 грн, рахунок вважається неактивним; в іншому випадку – активним.
Методи, що перевизначаються:

Поповнити рахунок: поповнення можливе лише для активного рахунку. Викликає успадкований метод.
Зняти гроші: зняття можливе лише для активного рахунку. Викликає успадкований метод.
Місячна виписка: якщо кількість зняттів перевищує 4, стягується комісія в 1000 грн за кожне додаткове зняття. Після виписки перевіряється, чи активний рахунок.
Друк інформації: повертає баланс, місячну комісію та кількість транзакцій (суму поповнень та зняттів).

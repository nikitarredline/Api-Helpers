## Требования для запуска интеграционных тестов
Для тестов с RabbitMQ и Selenoid нужно локально развернуть контейнеры:

### RabbitMQ
docker run -d --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3-management

### Selenoid
docker run -d --name selenoid -p 4444:4444 aerokube/selenoid:latest-release

- Тесты предполагают доступ к этим портам.

Порядок запуска тестов

Сначала поднять контейнеры, затем запустить тесты через IDE или mvn test.

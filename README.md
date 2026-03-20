# Event Manager - Spring Boot

Du an website quan ly su kien su dung:

- Spring Boot 3
- Spring MVC + Thymeleaf
- Spring Data JPA
- H2 Database

## Chuc nang hien tai

- Xem danh sach su kien
- Tao su kien moi
- Sua su kien
- Xoa su kien
- Validate du lieu (ten, dia diem, thoi gian, so luong)

## Cau truc chinh

- `src/main/java/com/eventmanager/controller/EventController.java`
- `src/main/java/com/eventmanager/service/EventService.java`
- `src/main/java/com/eventmanager/repository/EventRepository.java`
- `src/main/java/com/eventmanager/model/Event.java`
- `src/main/resources/templates/events/`

## Cach chay

1. Cai Java 17
2. Cai Maven
3. Chay lenh:

```bash
mvn spring-boot:run
```

4. Mo trinh duyet:

- `http://localhost:8080/events`
- H2 Console: `http://localhost:8080/h2-console`

## Ghi chu

- Database H2 dang chay in-memory, du lieu se mat sau khi tat app.

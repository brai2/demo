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

---

## Bai tap: CI/CD voi GitHub Actions + Docker Hub

### 1. Repository GitHub cua ban

Repo: **https://github.com/brai2/demo**

Trong thu muc project (`e:/java` hoac noi ban luu code), chay:

```bash
git init
git add .
git commit -m "Initial commit: Spring Boot + Docker + workflow"
git branch -M main
git remote add origin https://github.com/brai2/demo.git
git push -u origin main
```

Neu may da co `git init` / `remote` roi: chi can `git remote set-url origin https://github.com/brai2/demo.git` roi `git push -u origin main`.

### 2. Tao Secrets tren GitHub (Docker Hub)

1. Tren GitHub: repo cua ban -> **Settings** -> **Secrets and variables** -> **Actions** -> **New repository secret**.
2. Them 2 secret (dung dung ten de workflow nhan dien):

| Ten secret        | Gia tri |
|-------------------|---------|
| `DOCKER_USERNAME` | Ten dang nhap Docker Hub |
| `DOCKER_PASSWORD` | **Access Token** Docker Hub (khuyen nghi) hoac mat khau |

**Tao Access Token Docker Hub:** docker.com -> **Account Settings** -> **Security** -> **New Access Token**.

### 3. Workflow tu dong build & push image

- File: `.github/workflows/deploy.yml`
- Khi **push len nhanh `main`**: login Docker Hub -> `docker build` -> `docker push`
- Image tren Docker Hub: `<DOCKER_USERNAME>/event-manager:latest` va `<DOCKER_USERNAME>/event-manager:<7-ky-tu-commit>`

### 4. Chay image sau khi push

```bash
docker pull <dockerhub-username>/event-manager:latest
docker run -p 8080:8080 <dockerhub-username>/event-manager:latest
```

Mo `http://localhost:8080/events`.

# LokiDemoApplication

This is a simple Spring Boot application integrated with **Grafana Loki**, **Promtail**, and **Grafana** for centralized log aggregation and visualization. Promtail collects the application logs, pushed to Loki, and visualized in Grafana.

---

## 🧱 Project Structure
LokiDemoApplication/

├── Dockerfile

├── docker-compose.yml

├── promtail-config.yml

├── logs/

│ └── springboot-app.log

├── src/

│ └── main/java/com/example/LokiDemoApplication

│ └── LokiDemoApplication.java

├── application.properties

└── README.md

---

## 🚀 Features
- Spring Boot logging with stack traces
- Exception logs are captured automatically
- Logs saved to a mounted volume (`logs/`)
- Promtail monitors logs and pushes them to Loki
- Grafana for log querying and visualization

---

## 📦 Prerequisites
- Java 17
- Maven
- Docker & Docker Compose

---

## 🛠️ Build the Project
From the project root:

```bash
./mvnw clean package


---

## 🚀 Features
- Spring Boot logging with stack traces
- Exception logs are captured automatically
- Logs saved to a mounted volume (`logs/`)
- Promtail monitors logs and pushes them to Loki
- Grafana for log querying and visualization

---

## 📦 Prerequisites
- Java 17
- Maven
- Docker & Docker Compose

---

## 🛠️ Build the Project
From the project root:

```bash
./mvnw clean package

If you face permission errors during logging, ensure the logs/ directory exists and is writable:
sudo mkdir -p logs
sudo chmod 777 logs

🐳 Run the Full Stack (Spring Boot + Loki + Promtail + Grafana)
docker-compose up --build

Spring Boot App: http://localhost:8088

Grafana: http://localhost:3000
Grafana Default Login:
Username: admin
Password: admin

📄 Log Configuration
Logs are written to:
logs/springboot-app.log

In application.properties:
logging.file.name=logs/springboot-app.log
logging.level.root=INFO

The log format is customized in logback-spring.xml (optional) to show:
2025-05-27 13:42:10.345 [main] ERROR com.example.LokiDemoApplication - custom logger: 
java.lang.ArithmeticException: / by zero

📡 promtail-config.yml

Promtail is configured to read from the host's logs/springboot-app.log file:
scrape_configs:
  - job_name: springboot
    static_configs:
      - targets:
          - localhost
        labels:
          job: springboot
          __path__: /var/log/springboot-app.log
    pipeline_stages:
      - multiline:
          firstline: '^\d{4}-\d{2}-\d{2}'


Ensure docker-compose.yml mounts the logs folder correctly:
volumes:
  - ./logs:/app/logs      # Spring Boot app
  - ./logs:/var/log       # Promtail


🔍 View Logs in Grafana
1. Open http://localhost:3000
2. Log in with admin / admin
3. Add a Loki data source (URL: http://loki:3100)
4. Go to Explore
5. Select Loki data source
6. Use the query: {job="springboot"}


🧹 Cleanup
To stop and remove all containers: docker-compose down

📬 Contact
Maintained by: Roman
YouTube Channel: Learn Code With Roman


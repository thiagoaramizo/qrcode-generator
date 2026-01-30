# QR Code Generator

A minimalist, high-performance API and web interface for generating QR Codes on the fly. Built with Spring Boot and ZXing.

## Features

- **Fast & Lightweight**: Built with Spring Boot.
- **Minimalist UI**: Dark-themed, clean web interface for quick generation.
- **API First**: Simple REST endpoint for easy integration.
- **PIX Ready**: PIX "Copia e Cola" compatibility, you can generate QR Codes for PIX transactions from "Copia e Cola" keys.
- **Docker Ready**: Includes Dockerfile and Compose setup for easy deployment.

## Tech Stack

- **Java 21**
- **Spring Boot 4.0.2**
- **ZXing** (Zebra Crossing) for QR Code generation
- **Maven**
- **Docker**

## Getting Started

### Prerequisites

- Java 21 JDK
- Maven (or use the included `mvnw` wrapper)
- Docker (optional)

### Running Locally

1. Clone the repository:
   ```bash
   git clone https://github.com/aramizo/qrcode-generator.git
   cd qrcode-generator
   ```

2. Run with Maven Wrapper:
   ```bash
   ./mvnw spring-boot:run
   ```

3. Access the application at `http://localhost:3000`.

### Running with Docker

1. Build and start the container:
   ```bash
   docker-compose up -d --build
   ```

2. The application will be available at `http://localhost:3000`.

## API Usage

### Generate QR Code

**Endpoint:** `GET /generate`

**Query Parameters:**
- `content`: The text or URL to be encoded in the QR Code.

**Example Request:**
```http
GET http://localhost:3000/generate?content=https://example.com
```

**Response:**
```
data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAMgAAADIAQAAAAC...
```

## Deployment

This project includes a `Dockerfile` and `docker-compose.yml` optimized for deployment on platforms like **Easypanel**, **Coolify**, or any Docker-based environment.

## License

This project is licensed under the MIT License.

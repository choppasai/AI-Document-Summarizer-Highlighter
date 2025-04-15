#  AI Document Summarizer & Highlighter

A Spring Boot-based application that leverages powerful AI models like **OpenAI GPT** and **HuggingFace Transformers** to generate intelligent document summaries, extract key highlights, and answer user questions from document content.

---

##  Core Features

### 📄 1. AI-Powered Summarization
- Generate **concise, intelligent summaries** of long-form documents.
- Supports both:
  - **Abstractive summarization** (using GPT, T5, etc.)
  - **Extractive summarization** (key sentence extraction)
- Choose desired summary length: `short`, `medium`, or `detailed`.

###  2. Question Generation & Answering
- Automatically generate **potential questions** from the document.
- Users can ask custom questions, and the system answers based on document content using **QA over text**.

###  3. Multi-Format Document Support
- Upload and summarize:
  - `.pdf`
  - `.docx`
  - `.txt`
  - `.html`
- File content is extracted via **Apache Tika** and **PDFBox** for clean text parsing.

---

##  User Features

### 👤 4. User Authentication & History
- User registration and login with secure auth (Spring Security).
- Logged-in users can:
  - View document summary history
  - **Favorite** or **pin** summaries for quick access

###  5. Save & Share Summaries
- Export summaries and highlights as:
  - `.txt`
  - `.pdf`
- Share summaries via:
  - **Email**
  - **Public shareable links**

---
## 🧪 Back-of-the-Envelope Estimates

- Average file size: **50 MB**
- Daily active users: **10M**
- Uploads/day: **20M**
- Total daily storage: **~1 PB**
- Est. requests/sec: **~1K RPS peak**

✅ Designed with scalability, sharding & async processing in mind.

---

## Tech Stack

| Layer         | Tech                                     |
|---------------|------------------------------------------|
| Language      | Java 17                                  |
| Framework     | Spring Boot, Spring Security             |
| AI Integration| OpenAI API / HuggingFace Transformers    |
| File Parsing  | Apache Tika / PDFBox                     |
| Database      | PostgreSQL + JPA/Hibernate               |
| Storage       | AWS S3                                   |
| Build Tool    | Maven                                    |
| Deployment    | Docker + (K8s planned)                   |

---

## 🧰 Setup & Run (Local)

### Prerequisites
- Java 17+
- Maven
- PostgreSQL
- AWS credentials (for S3)
- OpenAI API Key

### Running Locally

bash
 - git clone https://github.com/choppasai/AI-Document-Summarizer-Highlighter.git
cd AI-Document-Summarizer-Highlighter
./mvnw spring-boot:run

---

## 🙌 Contributing
Feel free to open issues, suggest improvements, or create PRs.

---

## 📄 License
MIT License © 2025 [Manikanta__sai]

#  AI Document Summarizer & Highlighter

A Spring Boot-based application that leverages powerful AI models like **OpenAI GPT** and **HuggingFace Transformers (T5, BART)** to generate intelligent document summaries, extract key highlights, and answer user questions from document content.

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

##  Tech Stack

- **Backend**: Spring Boot, Java 17
- **AI Integration**: OpenAI API, HuggingFace API
- **File Parsing**: Apache Tika, PDFBox
- **Security**: Spring Security, JWT
- **Database**: PostgreSQL 
- **Frontend**:  React
- **Build Tools**: Maven 

---

##  Setup Instructions (Coming Soon)
Instructions for:
- Running locally
- API reference
- OpenAI token setup
- Deployment on Render


---

## 🙌 Contributing
Feel free to open issues, suggest improvements, or create PRs.

---

## 📄 License
MIT License © 2025 [YourName]

# AgDesk Sync System

A full-stack sync system for managing agricultural assets and tasks across local Android devices and a Django REST backend. 
Built as part of a capstone project for QUT.

---


## Overview

AgDesk allows users to:
- Track and manage farming equipment and maintenance tasks
- Sync data between local devices and a cloud server
- Use offline data entry and smart conflict resolution via timestamps

The system includes:
-  Android app (Kotlin)
-  Django REST API
-  Bi-directional sync logic using `uid` and `timestamp`

---

## Project Structure
```
AgDesk/
├── AgDesk/
│   ├── artefact/
│   │   └── OfflineFirstArtefact/
│   │       └── Artefact.md
│   ├── backend/
│   │   ├── api/
│   │   ├── backend/
│   │   ├── venv/
│   │   └── db.sqlite3
│   ├── documents/
│   ├── prototype/
│   │   └── AGDesk Proto JP/
│   │       └── prototype.md
│   └── README.md
```


## Setup Instructions
##  Python & Pip Setup

Before running the backend, make sure you have **Python 3.10+** and **pip** installed.

### Check if Python & pip are installed

```bash
python --version
pip --version
```

You should see something like:
```
Python 3.10.x
pip 21.x.x
```

> On some systems (especially macOS or Linux), use `python3` and `pip3` instead:
```bash
python3 --version
pip3 --version
```

---

### If Python is not installed:

Download the latest version of Python from the official website:

🔗 https://www.python.org/downloads/

During installation on Windows:
- Check the box that says **“Add Python to PATH”**
- Then click **“Install Now”**

---

### Optional: Upgrade pip to the latest version

```bash
python -m pip install --upgrade pip
```

or

```bash
python3 -m pip install --upgrade pip
```

### Backend (Django)

```bash
cd backend
python -m venv venv
source venv/bin/activate  # On Windows: venv\Scripts\activate
pip install -r requirements.txt
python manage.py migrate
python manage.py runserver
```
## API Endpoints

All API requests are made to your local backend running at:

```
http://127.0.0.1:8000/
```

| Method | Endpoint               | URL                                     | Description                                           |
|--------|------------------------|-----------------------------------------|-------------------------------------------------------|
| POST   | `update-master`        | `/api/update-master/`                   | Smart sync. Creates or updates assets/tasks based on timestamp and ID. |
| GET    | `fetch`                | `/api/fetch/`                           | Returns **all** local assets and tasks.              |
| POST   | `push`                 | `/api/push/`                            | Pushes local DB (assets/tasks) to cloud server.      |
| POST   | `update-sync`          | `/api/update-sync/`                     | Returns **only new or updated** records since a given timestamp. |

## 📚 Useful Resources
-  [Python Official Documentation](https://docs.python.org/3/)
-  [Django Documentation (REST Framework)](https://www.django-rest-framework.org/)
-  [Django Official Docs](https://docs.djangoproject.com/en/stable/)
-  [Kotlin Language Reference](https://kotlinlang.org/docs/home.html)
-  [Postman – API Testing Tool](https://www.postman.com/)
- 🧪 [UUID Info (Universally Unique Identifiers)](https://www.uuidgenerator.net/dev-corner/python)
-  [Epoch & Unix Timestamp Converter](https://www.epochconverter.com/)
-  [SQLite Docs (for local DB)](https://sqlite.org/docs.html)
```

---

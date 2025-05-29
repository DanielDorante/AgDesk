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
AgDesk/
├── AgDesk/ 
│ ├── artefact/ 
│ │ └── OfflineFirstArtefact/
│ │ └── Artefact.md
│ ├── backend/ 
│ │ ├── api/ 
│ │ ├── backend/ 
│ │ ├── venv/ 
│ │ └── db.sqlite3 
│ ├── documents/ 
│ ├── prototype/ 
│ │ └── AGDesk Proto JP/
│ │ └── prototype.md
│ └── README.md 
---

## Setup Instructions
### Backend (Django)

```bash
cd backend
python -m venv venv
source venv/bin/activate  # On Windows: venv\Scripts\activate
pip install -r requirements.txt
python manage.py migrate
python manage.py runserver

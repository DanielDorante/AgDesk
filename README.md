# AgDesk Offline First Andriod Application

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

Follow these steps to set up and run the backend locally:

```bash
cd backend
```
Navigate into the `backend` directory where the Django project lives.

```bash
python -m venv venv
```
Create a **virtual environment** named `venv` to isolate your Python dependencies.

```bash
source venv/bin/activate
# On Windows: venv\Scripts\activate
```
Activate the virtual environment so your terminal uses the local Python interpreter and packages.

```bash
pip install -r requirements.txt
```
Install all required Python packages listed in the `requirements.txt` file — this sets up Django, DRF, requests, etc.

```bash
python manage.py migrate
```
Apply any database migrations — this creates your tables (e.g. for Equipment and Task models) in `db.sqlite3`.

```bash
python manage.py runserver
```
Start the Django development server. By default, it runs at:
```
http://127.0.0.1:8000/
```
Use this address to make API requests locally or connect from your frontend app.

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

##  Expected Payload Format

The API expects incoming data in JSON format containing two main keys: `assets` and `tasks`. Each key maps to a list of objects representing records for the `Equipment` and `Task` models.

###  Example Payload

```json
{
  "assets": [
    {
      "assetPrefix": "TRACT",
      "name": "Field Tractor",
      "manufac": "Yanmar",
      "parts": "Engine, Tires, Seat",
      "location": "North Farm",
      "dateMade": 1673761800000,
      "dateBuy": 1679826000000,
      "image": "tractor.jpg",
      "farmId": 1,
      "largeEquipmentVin": "YNM1234",
      "vehicleVin": null,
      "serialNo": "SN54321",
      "reg": "REG4567",
      "syncId": null,
      "synctime": 1716768900000
    }
  ],
  "tasks": [
    {
      "name": "Replace Air Filter",
      "desc": "Swap out the air filter on the Yanmar tractor.",
      "timestamp": 1716768900000,
      "isDel": false,
      "due": 1717353600000,
      "exp": 1717526400000,
      "status": 0,
      "priority": 1,
      "assignedId": "worker_007",
      "assigned": "Alice",
      "farm": 1,
      "syncId": null,
      "synctime": 1716768900000
    }
  ]
}


##  Useful Resources
-  [Python Official Documentation](https://docs.python.org/3/)
-  [Django Documentation (REST Framework)](https://www.django-rest-framework.org/)
-  [Django Official Docs](https://docs.djangoproject.com/en/stable/)
-  [Kotlin Language Reference](https://kotlinlang.org/docs/home.html)
-  [Postman – API Testing Tool](https://www.postman.com/)
-  [UUID Info (Universally Unique Identifiers)](https://www.uuidgenerator.net/dev-corner/python)
-  [Epoch & Unix Timestamp Converter](https://www.epochconverter.com/)
-  [SQLite Docs (for local DB)](https://sqlite.org/docs.html)

##  Android Studio Agdesk app Setup

Download and install android studio using the default settings

https://developer.android.com/studio


Open Android studio

Navigate to File->Open and click on it

From the root directory of the repoistory navigate into /prototype/

Then select AGDesk Proto JP and click ok

Sync project files with gradel by pressing "Ctrl+Shift+O"

Ensure there is a virtual device by clicking on Device Manager on the right hand side of the screen

Then click the + symbol and "Add virtual device" then select the Pixel8a -> Next -> Finish

Then Press "Shift+F10" to launch build and launch the Emulator

## API LINK

If both of these are running on the same device the android emulator will be able to find the endpoint. Otherwith see NetworkRepository.kt to change the Url if hosting the endpoint elsewhere

## Resources
# Offline first

https://developer.android.com/topic/architecture/data-layer/offline-first
# Mvvm

https://www.geeksforgeeks.org/mvvm-model-view-viewmodel-architecture-pattern-in-android/
# Hilt

https://developer.android.com/training/dependency-injection/hilt-android
# Room

https://developer.android.com/training/data-storage/room/
# Ksp & Kapt

https://developer.android.com/build/migrate-to-ksp
# ViewModels

https://developer.android.com/topic/libraries/architecture/viewmodel
# Work Manager

https://developer.android.com/topic/libraries/architecture/workmanager/

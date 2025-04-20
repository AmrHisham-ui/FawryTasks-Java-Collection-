# FawryTasks-Java-Collection-
 
# 📸 Photo Gallery App (Java)

A simple Java-based Photo Gallery application that allows users to:

- Add photos with metadata (title, location, latitude, longitude, tags)
- Search photos by:
  - ID
  - Tag
  - Location
  - Latitude & Longitude
- Handles custom exceptions when no photo is found

---

## 🧠 Technologies Used

- Java 17+
- OOP (Object-Oriented Programming)
- Custom Exceptions
- Clean Code Practices (SOLID, High Cohesion, Low Coupling)

---

## 📂 Project Structure

/src ├── Model/ │ └── Photo.java ├── Service/ │ └── PhotoService.java ├── repository/ │ └── PhotoRepository.java ├── Gallery.java ├── Main.java ├── exception/ │ ├── PhotoNotFoundException.java │ ├── NoPhotosFoundException.java │ ├── NoPhotosFoundByLocationException.java │ └── NoPhotosFoundByLatLngException.java


## 🚀 How to Run

1. Clone the repo:
```bash
git clone https://github.com/your-username/photo-gallery-app.git
cd photo-gallery-app
javac Main.java
java Main

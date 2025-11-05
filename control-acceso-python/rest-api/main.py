# main.py
from fastapi import FastAPI, HTTPException
from typing import List
from database import users

app = FastAPI(
    title="Control de Acceso - REST",
    description="API REST para gestión de usuarios y acceso RFID",
    version="1.0"
)

@app.get("/")
def home():
    return {"message": "API REST con FastAPI - ¡Funciona!"}

@app.get("/users", response_model=List[dict])
def get_all_users():
    return users

@app.get("/users/{user_id}")
def get_user(user_id: int):
    user = next((u for u in users if u["id"] == user_id), None)
    if not user:
        raise HTTPException(status_code=404, detail="Usuario no encontrado")
    return user

@app.post("/access")
def access_control(card_id: str):
    user = next((u for u in users if u["card_id"] == card_id), None)
    if not user:
        raise HTTPException(status_code=403, detail="Acceso denegado")
    return {
        "status": "Acceso permitido",
        "user": user["name"],
        "door": "Aula 101",
        "timestamp": "2025-04-05 08:30:00"
    }
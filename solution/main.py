from fastapi import FastAPI
from fastapi.middleware.cors import CORSMiddleware

from typing import List
from pydantic import BaseModel

class IndicatorRequest(BaseModel):
    id: int
    pourcentage: float

from solution import indicateurs_financiers, build_phrase, build_phrase_global

import google.generativeai as genai

genai.configure(api_key="AIzaSyA5ZpJCsbRAvxH6z4m6MRGebpak9IhzKZ0")
model = genai.GenerativeModel("gemini-1.5-flash")

app = FastAPI()

origins = [
    "http://localhost:8087",
]

app.add_middleware(
    CORSMiddleware,
    allow_origins=origins,
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
)

@app.get("/suggestions")
def give_suggestions(id: int, pourcentage: float):
    indicateur = next((i for i in indicateurs_financiers if i["id"] == id), None)
    phrase = build_phrase(indicateur, pourcentage)
    print(phrase)
    response = model.generate_content(phrase)
    return {"solution": response.text}

@app.post("/suggestions")
def give_global_solution(indicators: List[IndicatorRequest]):
    phrase = build_phrase_global(indicators)
    print(phrase)
    response = model.generate_content(phrase)
    return {"solution": response.text}
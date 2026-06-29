
# import requests

# BASE_URL = "http://localhost:8080/students"

# headers = {
#     "x-api-key": "mysecret123"
# }

# student1 = {
#     "id": 1,
#     "name": "Thamarai",
#     "dept": "CSE"
# }
# student2 = {
#     "id": 2,
#     "name": "XXX",
#     "dept": "CSE"
# }
# student3 = {
#     "id": 3,
#     "name": "YYY",
#     "dept": "CSE"
# }
# student4 = {
#     "id": 4,
#     "name": "ZZZ",
#     "dept": "CSE"
# }
# # POST
# r = requests.post(BASE_URL, json=student1, headers=headers)
# print("POST:", r.status_code, r.text)
# r = requests.post(BASE_URL, json=student2, headers=headers)
# print("POST:", r.status_code, r.text)
# r = requests.post(BASE_URL, json=student3, headers=headers)
# print("POST:", r.status_code, r.text)
# r = requests.post(BASE_URL, json=student4, headers=headers)
# print("POST:", r.status_code, r.text)

# # GET
# r = requests.get(BASE_URL, headers=headers)
# print("GET:", r.status_code, r.text)

# # PUT
# updated = {
#     "id": 1,
#     "name": "Miyaw",
#     "dept": "IT"
# }

# r = requests.put(BASE_URL + "/1", json=updated, headers=headers)
# print("PUT:", r.status_code, r.text)

# # GET 
# r = requests.get(BASE_URL, headers=headers)
# print("GET:", r.status_code, r.text)


import requests

# LOGIN
res = requests.post("http://localhost:8080/auth/login", json={
    "username": "admin",
    "password": "1234"
})

token = res.text
print("TOKEN:", token)

# CALL PROTECTED API
headers = {
    "Authorization": f"Bearer {token}"
}

r = requests.get("http://localhost:8080/api/students", headers=headers)

print("Response:", r.text)
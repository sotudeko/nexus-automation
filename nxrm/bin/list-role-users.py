import requests
import json

repo_url = "http://localhost:8081"
repo_user = "admin"
repo_pwd = "admin123"

base_url = "service/rest"

roles = {}


def getData(end_point):
    url = "{}/{}/{}" . format(repo_url, base_url, end_point)

    req = requests.get(url, auth=(repo_user, repo_pwd), verify=False)

    if req.status_code == 200:
        res = req.json()
    else:
        res = "Error fetching data"

    return res


def inspect_users(users):
    for user in users:
        
        firstname = user["firstName"]
        lasttname = user["lastName"]
        id = user["userId"]
        user_name = id + " (" + firstname + " " + lasttname + ")"

        for role in user["roles"]:
            if role not in roles:
                roles[role] = []
                
            roles[role].append(user_name)
            
        
def main():
    users_endpoint = "v1/security/users"
    users = getData(users_endpoint) 
    
    #print(json.dumps(users, indent=2))
    
    inspect_users(users)

    print(json.dumps(roles, indent=2))
                
if __name__ == '__main__':
    main()
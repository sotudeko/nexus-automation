import sys
import requests
import json
import argparse
import getopt

repo_url = "http://localhost:8081"
repo_user = "admin"
repo_pwd = "admin123"

base_url = "service/rest"

roles = {}


def get_options():
    filter = None
    source = None
    
    argv = sys.argv[1:]
    
    try:
        opts, args = getopt.getopt(argv, "f:s:")
    except:
        print("Error")
        
    for opt, arg in opts:
        if opt in ['-f']:
            filter = arg
        elif opt in ['-s']:
            source = arg
            
    return filter, source


def getData(end_point):
    url = "{}/{}/{}" . format(repo_url, base_url, end_point)
    print(url)
    req = requests.get(url, auth=(repo_user, repo_pwd), verify=False)

    if req.status_code == 200:
        res = req.json()
    else:
        res = "Error fetching data"

    return res


def inspect_users(users):
    for user in users:
        
        user_name = ""
        firstname = ""
        lastname = ""
        
        id = user["userId"]
        user_name = id + " ("

        firstname = user["firstName"""]
        lastname = user["lastName"]
        
        if firstname:
            user_name += firstname
            
        if lastname:
            user_name += " " + lastname 
            
        user_name += ")"

        for role in user["roles"]:
            if role not in roles:
                roles[role] = []
                
            roles[role].append(user_name)
            
        
def main():
    users_endpoint = "v1/security/users"
    filter, source = get_options()
    
    if not filter is None:
        users_endpoint += "?userId=" + filter
        
    if not source is None:
        users_endpoint += "?source" + source
        
    users = getData(users_endpoint) 
    
    #print(json.dumps(users, indent=2))
    
    inspect_users(users)

    print(json.dumps(roles, indent=2))
                
if __name__ == '__main__':
    main()
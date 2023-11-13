import random
import string
def gen_random_digits(num):
    return ''.join(random.choice(string.digits) for _ in range(num))

def gen_random_alpha_digits(num):
    return ''.join(random.crhoice(string.ascii_letters + string.digits) for _ in range(num))

insertUserState = "insert into Role (roleID, roleDescription) values (\'{}\', \'{}\');"
methods = ["GET", "POST", "PUT", "DELETE", "PATCH"]
root_dir = ["user", "root"]
classes = ["first", "second"]
roleID = 0
for k in range(5):
    roleDescription = methods[k] + ' '
    for i in range(2):
        roleDescription += root_dir[i]
        for j in range(2):
            roleDescription += "/" + classes[j]
            print(insertUserState.format(roleID, roleDescription))
            roleID += 1
        roleDescription = methods[k] + ' '




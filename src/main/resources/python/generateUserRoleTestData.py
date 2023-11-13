import random
import string
def gen_random_digits(num):
    return ''.join(random.choice(string.digits) for _ in range(num))

def gen_random_alpha_digits(num):
    return ''.join(random.crhoice(string.ascii_letters + string.digits) for _ in range(num))

insertUserState = "insert into UserRole (roleID, userID) values (\'{}\', \'{}\');"


for k in range(10):
    roleID = str(random.randint(0, 19))
    userID = str(random.randint(0, 99))
    print(insertUserState.format(roleID, userID))




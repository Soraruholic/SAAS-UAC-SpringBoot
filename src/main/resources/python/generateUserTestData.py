import random
import string
def gen_random_digits(num):
    return ''.join(random.choice(string.digits) for _ in range(num))

def gen_random_alpha_digits(num):
    return ''.join(random.choice(string.ascii_letters + string.digits) for _ in range(num))

insertUserState = "insert into User (userID, userName, userPassword, userEmail, userPhone, lastPasswordResetDate) values (\'{}\', \'{}\', \'{}\', \'{}\', \'{}\', \'{}\');"
for i in range(100):
    userName = gen_random_alpha_digits(20)
    userID = i
    userPassword = gen_random_alpha_digits(20)
    userEmail = gen_random_digits(8) + "@qq.com"
    userPhone = gen_random_digits(11)
    lastPasswordResetDate = "2023-"+ str(random.randint(1,12)) +"-" + str(random.randint(1,31))
    print(insertUserState.format(userID, userName, userPassword, userEmail, userPhone, lastPasswordResetDate))


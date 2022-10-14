#     CSE 15L Week 1 Lab Tutorial
Created by: _Yang Han_

    Welcome to CSE 15L Week 1 lab. This lab covers remote access that enables you to control a computer remotely. Here is the  tutorial that will help you to complete all lab tasks. If you are unable to see the pictures, please click on the links provided.

1. __Setting up Visual Studio Code(VS Code)__

Note: if you have already had this program on your device, you can skip this step :)

VS code is a very powerful and handy platform for you to edit texts and codes. It offer you a lot of convenience compared to other editing measures. Here is the procedure to install this.

* First, click on the link below, it should lead you to the website shown in the picture 1 (if you are unable to access the link please search _Visual Studio Code_ in your browser). Then download and install VS Code.

    [Link_vscode](https://code.visualstudio.com/)

    ![initial_screen_1](https://tonyyanghan.github.io/cse15l-lab-reports/initial_screen.jpg)
    picture_1

    ![image_download_2](https://tonyyanghan.github.io/cse15l-lab-reports/downloading_vscode.jpg)
    picture_2


* Next, open VS Code. You should be able to see picture 3. To enter and run command, you will need to open the terminal in VS code. You can do this either by pressing _Ctrl+`_ or click on _Terminal_ on the top of the window and click on _New Terminal_.
![picture_3](https://tonyyanghan.github.io/cse15l-lab-reports/picture_3.jpg)

---

2. __Setting up SSH__

In order for SSH to function, you will need to have SSH Client. Please click on the link below and follow the instructions to see if you already have SSH client or need to install one.

[Checking/Installing_SSH](https://learn.microsoft.com/en-us/windows-server/administration/openssh/openssh_install_firstuse?tabs=gui)

---

3. __Looking up for Your Account__

    You have an account specifically for CSE 15L, and that is the account you are going to remotely access today. To find that account, please click on the following link

    [Link_to_account_search](https://sdacs.ucsd.edu/~icc/index.php)

* Enter your Username(the thing before @ in your college email address. For example, the user name of a person with email address abc001@ucsd.edu is _abc001_) and PID. You will be able to see your account name with format cs15lxxxxxx(). Copy it!

![picture_4](https://tonyyanghan.github.io/cse15l-lab-reports/account_lookup_4.jpg)

---

4. __Connecting to Your Remote Account__
* Enter _ssh_ to command line, then paste your account name. Add _@ieng6.ucsd.edu_ at the end.
For example: _accountname_@ieng6.ucsd.edu

* Since you are probably using SSH for the first time, the remote access may fail to establish. The system may ask you a question if you are continue connecting or not. Simply type _yes_ and press _enter_ key.

* The system will ask password from you. The default password is the same as your MyTritonLink.

* The system will return successful log in message or will ask you to enter the passwords again(which means log-in failed)
    
Note: If you are unable to log in, you will need to change the password by following the instrction below.

* Use the following link to reset password

[Password_Reset](https://sdacs.ucsd.edu/~icc/password.php)

* Wait 5-20 minutes before you try logging in again.

---

5. __Trying some commands__

ls : will list all documents under current directory
![local_ls_demo](https://github.com/TonyYangHan/cse15l-lab-reports/blob/1cf96aac845fe71416446f8958505e954f8cd7b4/ls_demo.jpg)

cd <path>: change directory to _path_

![local_cd_demo](https://github.com/TonyYangHan/cse15l-lab-reports/blob/1cf96aac845fe71416446f8958505e954f8cd7b4/cd_demo.jpg)

cat <file_name>/<path+file_name>: print file

![local_cat_demo](https://github.com/TonyYangHan/cse15l-lab-reports/blob/1cf96aac845fe71416446f8958505e954f8cd7b4/cat_demo.jpg)

cp <file_name>/<path+file_name>: copy file

![local_cp_demo_1](https://github.com/TonyYangHan/cse15l-lab-reports/blob/1cf96aac845fe71416446f8958505e954f8cd7b4/cp_demo_1.jpg)

![local_cp_demo_2](https://github.com/TonyYangHan/cse15l-lab-reports/blob/1cf96aac845fe71416446f8958505e954f8cd7b4/cp_demo_2.jpg)

exit: to log out the current remote account

---

6. __Using Secure Copy command (scp)__

* Firstly, create a file called WhereAmI.java to obtain some info about your current device and location. Please copy and paste the following code.

class WhereAmI {
  public static void main(String[] args) {
    System.out.println(System.getProperty("os.name"));
    System.out.println(System.getProperty("user.name"));
    System.out.println(System.getProperty("user.home"));
    System.out.println(System.getProperty("user.dir"));
  }
}

* Type _javac WhereAmI.java_ into the command line to compile and _java WhereAmI_ to run.

* Type _scp WhereAmI.java <account_name>@ieng6.ucsd.edu:~/_ to copy file from your device to that remote account.

* Now, since you are already logged in your remote account, you need to log off and log in again. Then, use _ls_ command to check if you can see the copied _WhereAmI.java_ file

* Now you have mastered another way to copy files remotely! Before you move on, please do the following:

a. Have someone on your team start a timer.

b. Make a change to WhereAmI.java and save the file.

c. Copy the file to the remote server

d. Log into the remote server and run the file

e. Stop the timer

f. Calculate and record the time it takes (in hours) to completed 100 times of operation a-e

---

7. __SSH keys__

The purpose of the test above is to see how boring it can be if you are copying many files and logging in many times. Thus, there is some thing called SSH keys for you. This acts as an ID card and automatically swipes and log into the remote account when you used _ssh <account_name>@ieng6.ucsd.edu_ command. How convenient! Let's find out how to do so.

* Using command _ssh-keygen_, you are creating a public key and a private key. The public key goes into your remote account and the private key will be saved to the current device you are using. Every time you log in, system will compared the public key and your private key to see if they match. If they matches, then you are in.

Note: 
a. When given the prompt Enter file in which to save the key, press enter again to specify the default path and record this path.

b. If you’re on Windows, follow the extra ssh-add steps here: [Link_ssh-add](https://docs.microsoft.com/en-us/windows-server/administration/openssh/openssh_keymanagement#user-key-generation)

* Now, log into your remote server. Type command _mkdir .ssh_ and then log out.

* Enter this command: _scp <public_key_file_path> cs15l<quarter>@ieng6.ucsd.edu:~/.ssh/authorized_keys_

* After this, you should be able to log into remote server without entering password.
---
8. Make the process even smoothier

* You can run multiple commands or copy multiple files at the same time! Just remember to separate each file with a space and use semicolon to separate different commands.

* Try timing the process and refine the process yourself!

__Thank you!__
__THE END__













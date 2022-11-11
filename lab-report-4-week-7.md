# CSE 15L Lab Report 4 Week 7

Author: Yang Han
PID: A16916031

Vim is a really useful tool when comes to editing files on a remote server. On a remote server, it is likely that there is no available and handy text editor such as VS Code. Vim offered people ability to edit files on the remote server directly without using scp to update files(which is a lot of typing).

## Part 1 Trying Vim
In this report, I will use vim to change all occurence of `start` in DocSearchServer.java on the remote server. The sequence of keys that I pressed are shown below.

Overall Sequence:
`/start<Enter>cebase<Esc>n.n.`

* When I just entered DocSearchServer.java using vim:

![Start](https://TonyYangHan.github.io/cse15l-lab-reports/start.jpg)

* After typing `/start`

We are searching the occurence of `start` parameter

![search_start](https://TonyYangHan.github.io/cse15l-lab-reports/search_start.jpg)

* Pressed `<Enter>`

We saved all search results by pressing `<Enter>`

![pressed_enter](https://TonyYangHan.github.io/cse15l-lab-reports/pressed_enter.jpg)

* Then typed `ce`

`c` means "change" `e` means "end of current word" We are now in Insert mode.

![typed_ce](https://TonyYangHan.github.io/cse15l-lab-reports/typed_ce.jpg)

* Then typed `base<Esc>`

`base` is the word to be inserted. `<Esc>` is to exit from Insert mode to Normal mode.

![base_with_esc](https://TonyYangHan.github.io/cse15l-lab-reports/base_with_esc.jpg)

* Then pressed `n`

This brings the cursor to the next search result.

![pressed-n](https://TonyYangHan.github.io/cse15l-lab-reports/pressed-n.jpg)

* Then pressed `.`

`.` means repeat the last modification (which is changing `start` to `base`) We avoided manually typing!

![pressed_fullStop](https://TonyYangHan.github.io/cse15l-lab-reports/pressed_fullStop.jpg)

* Pressed `n` again

This brings the cursor to the next search result (also the last one)

![pressed-n-again](https://TonyYangHan.github.io/cse15l-lab-reports/pressed-n-again.jpg)

* Pressed `.` again

We repeated the last modification (`start` to `base`) again.

![pressed_fullStop_again](https://TonyYangHan.github.io/cse15l-lab-reports/pressed_fullStop_again.jpg)

* Typed `:wq`

This command firstly save the file (`w`=write) then quit the Vim editor (`q`=quit)

![saved_file](https://TonyYangHan.github.io/cse15l-lab-reports/saved_file.jpg)

* Test if the modification works

Just in case, I run the file to check if my modification is correct. The server started, which means I successfully modified the file.

![successful_run](https://TonyYangHan.github.io/cse15l-lab-reports/successful_run.jpg)

---

## Part 2 Compare Vim and Local Editor

Let's compare if it would be more convenient to use Vim on the remote server to directly edit file or to modify the file locally and scp to the appropriate directory.

* Results:

I used 23.53 seconds using local editor and scp

I used 27.46 seconds using Vim on remote server

* Difficulty: I am not very familiar with Vim editor so the time using Vim could have been shorter

* Question 1:

Which of these two styles would you prefer using if you had to work on a program that you were running remotely, and why?

Generally, I prefer using local editor(VS Code) to edit the file and then scp it to the appropriate folder on the remote server. Because I am very familiar with local editor, I can make edits faster. Also, the local editor has AI assisted auto-completion during typing and error message display(red lines under codes), which help minimize errors. Typing scp command part is the most time-consuming one. However, if I typed the command previously, I can easily retrieve them by using up and down arrow so that I do not have to type again. Therefore, using the local editor then scp to the remote server will not only save some time but will also minimize the occurence of errors, which further saves time on debugging.

* Question 2:

What about the project or task might factor into your decision one way or another? (If nothing would affect your decision, say so and why!)

However, in acual working circumstances, the choice between local editor+scp and Vim depends on my intentions. For example, if I made a few typos in the file, it would be easier to use Vim since I can edit the file directly (As I become more familiar with Vim in the future, the edit time decreases)without typing/finding the correct scp command. However, for large edits, such as writing the first draft of code, I would prefer to use VS Code since it has automated completion(saves time in typing and reduces typos) and error message (redlines under the code to help prevent some error from occuring).

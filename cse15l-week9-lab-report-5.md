# CSE 15L Lab Report 5 Week 9

Author: Yang Han

PID: A16916031

Autograder is a very useful feature to evaluate a program. In this report, a grade.sh was made to grade "student submitted repos" in combination with TestListExamples.java.

* Here is the full code of grade.sh in a code block

```
CP=".:../lib/hamcrest-core-1.3.jar:../lib/junit-4.13.2.jar"
fileName="ListExamples.java"
score=2
rm -rf ~/week_7/student-submission
git clone $1 ~/week_7/student-submission
echo "cloned"
cp TestListExamples.java ~/week_7/student-submission
echo "copied"
cd ~/week_7/student-submission
echo "in the dir"

if [ -f $fileName ] && [ -e $fileName ]
then
    echo "File Found"
else
    echo "ERROR: File Not Found"
    score=0
    echo "Your score: $score/2"
    exit 1
fi

javac -cp $CP *.java
if [ $? != 0 ]
then
    echo "Compile_Error!"
    score=0
    echo "Your score: $score/2"
    exit 2
fi

echo "compiled"
java -cp $CP org.junit.runner.JUnitCore TestListExamples > std_out.txt
echo "java executed"

if [ $(grep -c "testFilter_CheckAll(TestListExamples)" std_out.txt) -eq 1 ]
then
    let "score-=1"
    echo "Failed test: testFilter_CheckAll"
fi

if [ $(grep -c "testMerge_sorted(TestListExamples)" std_out.txt) -eq 1 ]
then
    let "score-=1"
    echo "Failed test: testMerge_sorted"
fi

echo "Your score: $score/2"
```

---

* GradeExample_1 (lab 3 original repo)

![GraderServer_1](https://TonyYangHan.github.io/cse15l-lab-reports/GradeServer_1.png)

* GradeExample_2 (corrected repo)

![GradeServer_2](https://TonyYangHan.github.io/cse15l-lab-reports/GradeServer_2.png)

* GradeExample_3 (the one mission a semicolon)

![GradeServer_3](https://TonyYangHan.github.io/cse15l-lab-reports/GradeServer_3.png)

---

* Tracing GradeServer_2 (corrected repo):

When the URL is loaded with repo to the Grade Server, the GradeServer.java splits the query and run bash command with argument grade.sh and the repo specified in the URL.

### Part 1:

```
CP=".:../lib/hamcrest-core-1.3.jar:../lib/junit-4.13.2.jar"
fileName="ListExamples.java"
score=2
rm -rf ~/week_7/student-submission
git clone $1 ~/week_7/student-submission
echo "cloned"
cp TestListExamples.java ~/week_7/student-submission
echo "copied"
cd ~/week_7/student-submission
echo "in the dir"
```

From the start of the program to line 12 `echo "in the dir"` can hardly be wrong since they are defining variables, cloning the repo, copying the test files, and reporint the status using echo. Thus, there are hardly any standard error if the URL given is correct. There are also no standard outputs for these commands except `git clone` and `echo`. The first standard output that prints is from `git clone`:

```
Cloning into '/home/linux/ieng6/cs15lfa22/cs15lfa22qj/week_7/student-submission'...
```

Then as the program proceeds, it echos

```
cloned
copied
in the dir
```

### Part 2

```
if [ -f $fileName ] && [ -e $fileName ]
then
    echo "File Found"
else
    echo "ERROR: File Not Found"
    score=0
    echo "Your score: $score/2"
    exit 1
fi
```

Now we are in the student-submission directory. The if statement in line 14 checks if the file `ListExampels.java` exists. It is evaluated to be true because `ListExamples.java` does exist in the corrected repo so it `echo "File Found"`.

### Part 3

```
javac -cp $CP *.java
if [ $? != 0 ]
then
    echo "Compile_Error!"
    score=0
    echo "Your score: $score/2"
    exit 2
fi

echo "compiled"
```

Then javac in line 24 runs to compile all *.java files in the repo along with the test files. There are no standard output or standard error because the corrected `ListExamples.java` compiles without error. The exit code is 0.

The if statement that follows evaluates to be false because the exit code ($?) is 0. Then the program `echo "compiled"` to report the status.

### Part 4

```
java -cp $CP org.junit.runner.JUnitCore TestListExamples > std_out.txt
echo "java executed"
```

In this part, `java` runs the compiled `ListExamples.java` along with test files. The standard output is directed into `std_out.txt`. There are no standard error because the corrected `ListExamples.java` runs perfectly. The exit code is 0 since there is no error. The program then `echo "java executed"`.

The standard output is like this:

```
JUnit version 4.13.2
..
Time: 0.01

OK (2 tests)
```

### Part 5

```
if [ $(grep -c "testFilter_CheckAll(TestListExamples)" std_out.txt) -eq 1 ]
then
    let "score-=1"
    echo "Failed test: testFilter_CheckAll"
fi

if [ $(grep -c "testMerge_sorted(TestListExamples)" std_out.txt) -eq 1 ]
then
    let "score-=1"
    echo "Failed test: testMerge_sorted"
fi

echo "Your score: $score/2"
```

If there was any tests that failed, it would be re-directed into `std_out.txt`. The greps in the if statement check which test fails. In this case, both of them are evaluated to be false because there are no test failed in `std_out.txt`. Finally, `echo` prints the final `score` out of 2. Since the `ListExamples.java` is all correct, it prints `Your score: 2/2`.


## The end. Thank you!




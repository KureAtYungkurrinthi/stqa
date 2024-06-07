# Assignment 2: Automated Code Generation and Unit Testing

<!-- TOC -->
* [Assignment 2: Automated Code Generation and Unit Testing](#assignment-2-automated-code-generation-and-unit-testing)
  * [List of Prompts used to generate the code](#list-of-prompts-used-to-generate-the-code)
    * [Initial prompt](#initial-prompt)
    * [Initial response](#initial-response)
    * [Follow-up prompt](#follow-up-prompt)
    * [Follow-up response](#follow-up-response)
  * [Documentation of unit test cases](#documentation-of-unit-test-cases)
    * [Test result](#test-result)
      * [Submission](#submission)
      * [Course](#course)
      * [User](#user)
      * [Calendar](#calendar)
      * [Authentication](#authentication)
      * [Forum](#forum)
    * [Coverage report](#coverage-report)
    * [Discussion](#discussion)
  * [Conclusion and Final Recommendations](#conclusion-and-final-recommendations)
  * [References](#references)
<!-- TOC -->

## List of Prompts used to generate the code

### Initial prompt

<blockquote>
As a skilled Java developer, you are tasked to write a console-only Learning Management System (LMS) for Flinders University using Java. The LMS has the following requirements:

- Every student and academic staff should be authenticated while entering the LMS.
- Students will be able to access all their course material through the LMS.
- An academic calendar will highlight all the assignment and exam schedules for convenience and time management.
- Students will be able to upload assignments, take part in online exams and check their grades through the LMS.
- Academics should be able to upload contents and communicate with students through open student discussion forums.
- For privacy protection, the LMS will request authentication after any inactivity of ten minutes after opening the LMS
  page.
- A user will be able to log out at any time from the LMS page.

You must remember that this task is very important, and you must follow Java best practices.
</blockquote>

### Initial response

<blockquote>
Creating a console-only Learning Management System (LMS) in Java for Flinders University involves several components and functionalities. Here, I will outline a basic structure and then provide implementations for some of the key features. This project includes user authentication, course material access, an academic calendar, assignment upload, online exams, grade checking, and discussion forums.

Here’s a basic outline of the classes and features required:

1. **User Authentication**
    - User class (Student, AcademicStaff)
    - AuthenticationService class

2. **Course Material Access**
    - CourseMaterial class
    - CourseService class

3. **Academic Calendar**
    - CalendarEvent class
    - CalendarService class

4. **Assignments and Exams**
    - Assignment class
    - Exam class
    - SubmissionService class

5. **Grades**
    - Grade class
    - GradeService class

6. **Discussion Forums**
    - ForumPost class
    - ForumService class

7. **Main Application**
    - Main class with main method
    - Inactivity timer

Below is an example implementation of some core components:

(code omitted)

**Inactivity Timer**

The inactivity timer is checked in the `Main` class by comparing the current time to the `lastActivityTime`.

**Conclusion**

This implementation provides a basic structure for the LMS. You can expand the functionalities such as assignment
upload, exam handling, grade checking, and discussion forums following similar patterns. Ensure to use Java best
practices such as encapsulation, single responsibility, and separation of concerns when extending the system. Also, for
a real-world application, consider using a database for persistent storage and handling more complex authentication
mechanisms securely.
</blockquote>

### Follow-up prompt

<blockquote>
Do not simulate, but complete those functionalities. Remember, a lot of people are depending on you!
</blockquote>

### Follow-up response

<blockquote>
Certainly! Below is a more complete implementation of the LMS, including full functionalities for user interaction. This implementation covers authentication, viewing course materials, uploading assignments, taking exams, checking grades, and managing the academic calendar and discussion forums.

(code omitted)

**Conclusion**

This complete implementation includes all the required functionalities, such as user authentication, viewing course
materials, uploading assignments, taking online exams, checking grades, managing the academic calendar, and
participating in discussion forums. It follows Java best practices and ensures that the system is modular and
maintainable.

For a real-world application, consider using a database for persistent storage and improving security measures such as
password hashing and proper session management.
</blockquote>

## Documentation of unit test cases

### Test result

#### Submission

| No. | Component Name                               | Test Type  | Input              | Expected                         | Actual      | Status |
|-----|----------------------------------------------|------------|--------------------|----------------------------------|-------------|--------|
| S01 | uploadAssignment() & getStudentAssignments() | Functional | Assignment objects | Same objects as provided in list | As Expected | Pass   |
| S02 | submitExam() & getStudentExams()             | Functional | Exam objects       | Same objects as provided in list | As Expected | Pass   |
| S03 | gradeStudent() & getStudentGrades()          | Functional | Grade objects      | Same objects as provided in list | As Expected | Pass   |

#### Course

| No. | Component Name                               | Test Type  | Input  | Expected                         | Actual      | Status |
|-----|----------------------------------------------|------------|--------|----------------------------------|-------------|--------|
| C01 | uploadCourseMaterial() & getCourseMaterial() | Functional | String | Appended to existing course code | As Expected | Pass   |
| C02 | uploadCourseMaterial() & getCourseMaterial() | Functional | String | Created a new course list        | As Expected | Pass   |

#### User

| No. | Component Name                     | Test Type   | Input                         | Expected                     | Actual      | Status |
|-----|------------------------------------|-------------|-------------------------------|------------------------------|-------------|--------|
| U01 | addGrade() & getGrades()           | Functional  | Grade object                  | Correct grades returned      | As Expected | Pass   |
| U02 | setter & getter                    | Unit        | Set/Get username and password | student, password123         | As Expected | Pass   |
| U03 | setter & getter                    | Unit        | Set/Get username and password | staff, password456           | As Expected | Pass   |
| U04 | setter & getter                    | Unit        | Set/Get username and password | !#$%&'(), !#$%&()            | As Expected | Pass   |
| U05 | addExam() & getExams()             | Functional  | Exam object                   | Correct exams returned       | As Expected | Pass   |
| U06 | instanceof                         | Constructor | Distinguish user type         | Correct user type identified | As Expected | Pass   |
| U07 | displayMenu()                      | Functional  |                               | Correct menu displayed       | As Expected | Pass   |
| U08 | addAssignment() & getAssignments() | Functional  | Assignment object             | Correct assignments returned | As Expected | Pass   |

#### Calendar

| No. | Component Name           | Test Type | Input                | Expected                     | Actual      | Status |
|-----|--------------------------|-----------|----------------------|------------------------------|-------------|--------|
| C01 | addEvent() & getEvents() | Unit      | CalendarEvent object | Assignment 1 Due, 2024-06-15 | As Expected | Pass   |
| C02 | addEvent() & getEvents() | Unit      | CalendarEvent object | Midterm Exam, 2024-07-01     | As Expected | Pass   |
| C03 | addEvent() & getEvents() | Unit      | CalendarEvent object | Assignment 2 Due, 2024-07-15 | As Expected | Pass   |
| C04 | addEvent() & getEvents() | Unit      | CalendarEvent object | Final Exam, 2024-07-30       | As Expected | Pass   |

#### Authentication

| No. | Component Name | Test Type | Input                 | Expected                  | Actual      | Status |
|-----|----------------|-----------|-----------------------|---------------------------|-------------|--------|
| A01 | authenticate() | Unit      | student2, password456 | Authentication failed     | As Expected | Pass   |
| A02 | authenticate() | Unit      | staff1, password456   | Authentication failed     | As Expected | Pass   |
| A03 | authenticate() | Unit      | student1, password123 | Authentication successful | As Expected | Pass   |
| A04 | authenticate() | Unit      | staff1, password123   | Authentication successful | As Expected | Pass   |

#### Forum

| No. | Component Name        | Test Type  | Input            | Expected                         | Actual      | Status |
|-----|-----------------------|------------|------------------|----------------------------------|-------------|--------|
| F01 | addPost() &getPosts() | Functional | ForumPost object | Same objects as provided in list | As Expected | Pass   |

### Coverage report

| Class                 | Class, %      | Method, %     | Branch, %    | Line, %       |
|-----------------------|---------------|---------------|--------------|---------------|
| (All Classes)         | 93.3% (14/15) | 80.6% (50/62) | 17.1% (6/35) | 51% (100/196) |
| AcademicStaff         | 100% (1/1)    | 100% (2/2)    |              | 100% (7/7)    |
| Assignment            | 100% (1/1)    | 100% (3/3)    |              | 100% (5/5)    |
| AuthenticationService | 100% (1/1)    | 100% (2/2)    | 100% (4/4)   | 100% (8/8)    |
| CalendarEvent         | 100% (1/1)    | 100% (3/3)    |              | 100% (5/5)    |
| CalendarService       | 100% (1/1)    | 100% (3/3)    |              | 100% (6/6)    |
| CourseMaterial        | 100% (1/1)    | 100% (4/4)    |              | 100% (6/6)    |
| CourseService         | 100% (1/1)    | 100% (3/3)    | 100% (2/2)   | 100% (12/12)  |
| Exam                  | 100% (1/1)    | 100% (3/3)    |              | 100% (5/5)    |
| ForumPost             | 100% (1/1)    | 100% (3/3)    |              | 100% (5/5)    |
| ForumService          | 100% (1/1)    | 100% (3/3)    |              | 100% (4/4)    |
| Grade                 | 100% (1/1)    | 100% (3/3)    |              | 100% (5/5)    |
| Main                  | 0% (0/1)      | 0% (0/12)     | 0% (0/29)    | 0% (0/96)     |
| Student               | 100% (1/1)    | 100% (8/8)    |              | 100% (17/17)  |
| SubmissionService     | 100% (1/1)    | 100% (7/7)    |              | 100% (10/10)  |
| User                  | 100% (1/1)    | 100% (3/3)    |              | 100% (5/5)    |

### Discussion

Writing test cases for AI-generated code can be frustrating at best. This is due to AI often ignoring the principles of
object-oriented programming, keeping all complex logic in the main methods without regard for testability or
readability.

In our case, despite multiple instructions for it to take a more modular approach, we are still unable to test the most
critical logic as those are private functions in the main class. Furthermore, despite our instructions implying
requirements for data types and date boundaries, the generated code lacks such considerations. For example, it stores
all variables as “String” types, making it pointless to write test cases for. In another case, although it implemented a
way to store inactivity times and a function to hard interrupt the program (which isn’t an ideal way to begin with),
that function was never called.

We have, to the best of our ability, written test cases for all accessible functions, but those functions are either
simple or duplicated. Instead of writing test cases tailored towards code generated by AI, next time it might be more
feasible to create architecture and class definitions first, create test cases for all edge conditions, and use AI to
generate code based on our human-proofed definitions.

## Conclusion and Final Recommendations

This experience of automated code generation technologies is far from ideal, and the generated code does not meet the
quality of our previous programming assignments. Writing test cases for finished and unchangeable code has proven
to be frustrating and puzzling. As a result, the completed unit tests only confirm what the generated code can do, not
what it is supposed to do according to the requirements.

One major issue we detected in the generated code is the lack of understanding of the connections between various parts
of the requirements or the various parts of the codebase. For instance, although the generated code stores student
assignments, exams, and grades within the individual User object, the AI then reimplemented them into a Submission
Service within the same Java file, making the former completely redundant. These kinds of coding practices imply that
the AI lacks a general understanding of software requirements, and the generated code is merely a collection of code
snippets that it cannot comprehend. Therefore, when using AI to generate entire project, it’s code may contain subtle
bugs, security vulnerabilities, or inefficient implementations that are difficult to detect and fix.

Review of existing literatures, which reveal AI’s limitations in correctness, complexity, security, and error-fixing
ability, also proven our observation. The current use of ChatGPT code is primarily limited to concept demonstration or
documentation examples rather than being employed in production code [1]. While ChatGPT performs well on easy and
repetitive tasks, it encounters difficulties when faced with more complicated requirements [2]. ChatGPT struggles to
directly fix erroneous code through multi-round prompting, which has limited ability to resolve errors and generally
maintains or increases complexity [3], [4], [5]. ChatGPT has shown potentials in education by providing concise,
accurate, and user-friendly code explanations [6], and can improve student’s code quality by automating the code review
process [7]. However, study also found that ChatGPT use greatly reduced students' exploration of other resources, and
this reliance on the AI did not guarantee better outcomes [8].

In conclusion, AI-generated code can help making our work more efficient by reduce time in repetitive task and search
for solutions on the web, at this stage it still cannot replace any part of software developing process. It is
recommended that AI should only be used in creating small section of well-defined functions, and it is essential to
careful evaluation, testing, and human oversight when incorporating AI-generated code into any project.

## References

[1] K. Jin, C.-Y. Wang, H. V. Pham, and H. Hemmati, "Can ChatGPT Support Developers? An Empirical Evaluation of Large
Language Models for Code Generation." Mar. 16, 2024. doi: 10.1145/3643991.3645074.

[2] A. Bucaioni, H. Ekedahl, V. Helander, and P. T. Nguyen, "Programming with ChatGPT: How far can we go?," *Mach.
Learn. Appl.*, vol. 15, p. 100526, Mar. 2024, doi: 10.1016/j.mlwa.2024.100526.

[3] Z. Liu, Y. Tang, X. Luo, Y. Zhou, and L. F. Zhang, "No Need to Lift a Finger Anymore? Assessing the Quality of Code
Generation by ChatGPT," *IEEE Trans. Softw. Eng.*, pp. 1--35, 2024, doi: 10.1109/TSE.2024.3392499.

[4] Y. Liu *et al.*, "Refining ChatGPT-Generated Code: Characterizing and Mitigating Code Quality Issues," *ACM Trans.
Softw. Eng. Methodol.*, vol. 33, no. 5, p. 116:1-116:26, Jun. 2024, doi: 10.1145/3643674.

[5] F. A. Sakib, S. H. Khan, and A. H. M. R. Karim, "Extending the Frontier of ChatGPT: Code Generation and Debugging."
arXiv, Jul. 17, 2023. doi: 10.48550/arXiv.2307.08260.

[6] E. Chen, R. Huang, H.-S. Chen, Y.-H. Tseng, and L.-Y. Li, "GPTutor: A ChatGPT-Powered Programming Tool for Code
Explanation," in *Artificial Intelligence in Education. Posters and Late Breaking Results, Workshops and Tutorials,
Industry and Innovation Tracks, Practitioners, Doctoral Consortium and Blue Sky*, N. Wang, G. Rebolledo-Mendez, V.
Dimitrova, N. Matsuda, and O. C. Santos, Eds., Cham: Springer Nature Switzerland, 2023, pp. 321--327. doi:
10.1007/978-3-031-36336-8_50.

[7] Q. Guo *et al.*, "Exploring the Potential of ChatGPT in Automated Code Refinement: An Empirical Study," in
*Proceedings of the IEEE/ACM 46th International Conference on Software Engineering*, in ICSE '24. New York, NY, USA:
Association for Computing Machinery, Feb. 2024, pp. 1--13. doi: 10.1145/3597503.3623306.

[8] Y. Xue, H. Chen, G. R. Bai, R. Tairas, and Y. Huang, "Does ChatGPT Help With Introductory Programming?An Experiment
of Students Using ChatGPT in CS1," in *Proceedings of the 46th International Conference on Software Engineering:
Software Engineering Education and Training*, in ICSE-SEET '24. New York, NY, USA: Association for Computing Machinery,
May 2024, pp. 331--341. doi: 10.1145/3639474.3640076.

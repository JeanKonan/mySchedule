//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    val mySchool= School("Rexburg High School")

    // Create some courses
    val course1 = Course("Introduction to Programming", "CS101")
    val course2 = Course("Calculus I", "MATH101")

    // Create some teachers
    val teacher1 = Teacher("John Doe", course1)
    val teacher2 = Teacher("Jane Smith", course2)

    // Add new teachers and new courses

    mySchool.insertCourse(course1)
    mySchool.insertCourse(course2)
    mySchool.insertTeacher(teacher1)
    mySchool.insertTeacher(teacher2)

    // Print class details
    println("School Details:")
    println(mySchool.displayTeachers())
    println(mySchool.displayCourses())
}
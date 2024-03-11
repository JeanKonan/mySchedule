import java.io.File

class School (
    var name: String
) {
    var courseList: MutableList<Course> = mutableListOf()
    var teacherList: MutableList<Teacher> = mutableListOf()
    var hoursList: MutableList<Hour> = mutableListOf()
    var classList: MutableList<Class> = mutableListOf()
    var schedules: MutableList<ClassSchedule> = mutableListOf()

    fun addClass(cls: Class) {
        classList.add(cls)
    }

    fun addCourse(course: Course) {
        courseList.add(course)
    }

    fun getCourse(courseName: String): Course? {
        for (course in courseList){
            if (course.name == courseName){
                return course
            }
        }
        return null
    }

    fun addTeacher(teacher: Teacher) {
        teacherList.add(teacher)
    }

    fun getTeacher(teacherName: String): Teacher? {
        for (teacher in teacherList){
            if (teacher.name == teacherName){
                return teacher
            }
        }
        return null
    }

    fun getHour(hrStart: String): Hour? {
        for (hour in hoursList) {
            if (hour.start == hrStart) return hour
        }
        return null
    }

    fun addHour(hr: Hour){
        hoursList.add(hr)
    }

    fun insertTeacher(aTeacher: Teacher?){
        if (aTeacher != null){
            addTeacher(aTeacher)
        }
        else {
            println("Teacher's name: ")
            val teacherName: String? = readLine()
            println("Course: ")
            val  teacherCourse: String? = readLine()

            if (teacherName != null && teacherCourse != null) {
                val course: Course? = this.getCourse(teacherCourse)
                var newTeacher: Teacher? = null
                newTeacher?.setTeacher(teacherName, course)

                if (newTeacher != null) {
                    this.addTeacher(newTeacher)
                }
            }
            else {
                println("This course does not exist.")
            }
        }
    }

    fun insertClass(aClass: Class?){
        if (aClass != null){
            addClass(aClass)
        }
        else {
            println("Class: ")
            val className: String = readLine().toString()

            var newClass = Class(className)

            if (newClass.name != "") {
                this.addClass(newClass)
            }
        }
    }

    fun insertCourse(aCourse: Course?){
        if (aCourse != null){
            this.addCourse(aCourse)
        }
        else {
            println("Course: ")
            val courseName = readLine()
            println("Course code: ")
            val  courseCode = readLine()

            if (courseName != null && courseCode != null) {
                var myCourse: Course? = null

                myCourse?.setCourse(courseName, courseCode)
                if (myCourse != null) {
                    this.addCourse(myCourse)
                }
            }
        }
    }

    fun insertHour(hour: Hour?){
        if (hour != null){
            addHour(hour)
        }
        else {
            println("Start: ")
            val hrStart: String? = readLine()
            println("End: ")
            val  hrEnd: String? = readLine()

            if (hrStart != null && hrEnd != null) {
                val hr = this.getHour(hrStart)

                if (hr == null) {
                    val newHour = Hour(hrStart, hrEnd)

                    this.addHour(newHour)
                }
            }
        }
    }

    fun addSubject(): String {
        println("What is the subject's name?: ")
        var subj = readLine().toString()

        println("What weekdays is it offered?(Mon,Tue,...,Fri) :")
        var  days = readLine().toString()

        println("What time/span is it start for each weekday? (9h/2,10h/1...): ")
        var time = readLine().toString()

        var subjects: String = ""
        subjects = "$subj - $days - $time"

        return subjects
    }
    fun createSchedule() {

        println("What is the class?: ")
        var clsrm = readLine().toString()

        println("Who is the principal teacher?: ")
        var pp = readLine().toString()
        var teacher = this.getTeacher(pp)

        var mySubjects: MutableList<String> = mutableListOf()
        var answer = ""

        do {

            println("Add a new subject? (Y/N): ")
            answer = readLine().toString()

            if (answer.lowercase() == "y") {

                val subject = this.addSubject()
                mySubjects.add(subject)

            }

        } while (answer.lowercase() != "n")

        val clsSchedule = ClassSchedule(clsrm, teacher, mySubjects)

        schedules.add(clsSchedule)

        val fileName = "class_schedule.csv"
        var content = ""
        for (schedule in schedules) {

            content += "${schedule.classroom}, ${schedule.principal}, ${schedule.subjects}"

        }
        File(fileName).writeText(content)
    }

    fun displayClassSchedule(cls: String) {
        val fileName = "class_schedule.csv"
        var file_lines = File(fileName).readText().lines()

        for (line_content in file_lines) {

            var content = line_content.split(",")
            
        }
    }

    fun  displayCourses(){
        for (course in courseList){
            println("Course: ${course.name} - ${course.code}")
        }
    }

    fun  displayClasses(){
        for (cls in classList){
            println(cls.name)
        }
    }

    fun  displayTeachers(){
        for (teacher in teacherList){
            println("Teacher: ${teacher.name}")
            println("Course: ${teacher.course}")
        }
    }
}
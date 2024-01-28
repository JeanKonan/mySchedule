class School (
    var name: String
) {
    var courseList: MutableList<Course> = mutableListOf()
    var teacherList: MutableList<Teacher> = mutableListOf()
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

    fun  displayCourses(){
        for (course in courseList){
            println("Course: ${course.name} - ${course.code}")
        }
    }

    fun  displayTeachers(){
        for (teacher in teacherList){
            println("Teacher: ${teacher.name}")
            println("Course: ${teacher.course}")
        }
    }
}
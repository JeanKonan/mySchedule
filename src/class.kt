class Class (
    var name: String,
    var principal: Teacher,
    var teachers: List<Teacher>,
    var courses: MutableList<MutableList<String>>,
){
    fun setClass(nm: String, pp: Teacher, myTeachers: List<Teacher>, myCourses: MutableList<MutableList<String>>){
        this.name = nm
        this.principal = pp
        this.teachers = myTeachers
        this.courses = myCourses
    }
}
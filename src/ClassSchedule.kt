class ClassSchedule (
    var classroom: String,
    var principal: Teacher?,
//    var teachers: List<Teacher>,
    var subjects: MutableList<String>,
){
    fun setClass(clsrm: String, pp: Teacher?, myTeachers: List<Teacher>, mySubj: MutableList<String>){
        this.classroom = clsrm
        this.principal = pp
//        this.teachers = myTeachers
        this.subjects = mySubj
    }
}
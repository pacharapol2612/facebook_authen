package com.example.facebook_authen

class Student(var name: String, var score: Float) {
    companion object {
        fun getSampleStudentData(): ArrayList<Student> {
            val student: ArrayList<Student> = ArrayList()
            student.add(Student("อำเภอเมืองชลบุรี", 32.toFloat()))
            student.add(Student("อำเภอบ้านบึง", 32.toFloat()))
            student.add(Student("อำเภอหนองใหญ่", 33.toFloat()))
            student.add(Student("อำเภอบางละมุง", 31.toFloat()))
            student.add(Student("อำเภอพานทอง", 33.toFloat()))
            student.add(Student("อำเภอพนัสนิคม", 33.toFloat()))
            student.add(Student("ศรีราชา", 32.toFloat()))
            student.add(Student("เกาะสีชั", 31.toFloat()))
            student.add(Student("สัตหีบ", 31.toFloat()))
            student.add(Student("สัตหีบ", 32.toFloat()))
            student.add(Student("เกาะจันทร์", 33.toFloat()))
            return student
        }
    }

}

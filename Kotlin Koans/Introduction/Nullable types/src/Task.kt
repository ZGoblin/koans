fun sendMessageToClient(
        client: Client?, message: String?, mailer: Mailer
) {
    client?.let {
        it.personalInfo?.let {
            it.email?.let {
                message?.let {
                    mailer.sendMessage(client.personalInfo!!.email!!, it)
                }
            }
        }
    }
    return
}

class Client(val personalInfo: PersonalInfo?)
class PersonalInfo(val email: String?)
interface Mailer {
    fun sendMessage(email: String, message: String)
}

async function issueCertificate() {

    let participantId =
        document.getElementById("participantId").value;

    let courseId =
        document.getElementById("courseId").value;

    let response =
        await fetch(
            "http://localhost:8080/api/certificates",
            {
                method:"POST",

                headers:{
                    "Content-Type":"application/json"
                },

                body:JSON.stringify({
                    participantId:participantId,
                    courseId:courseId
                })
            }
        );

    let data =
        await response.json();

    document.getElementById("output").innerHTML =
        "Certificate ID : "
        + data.certificateId
        + "<br><br>"
        + "Verification Code : "
        + data.verificationCode;
}

async function revokeCertificate() {

    let id =
        document.getElementById("certificateId").value;

    await fetch(
        "http://localhost:8080/api/certificates/"
        + id
        + "/revoke",
        {
            method:"PUT"
        });

    alert("Certificate Revoked Successfully");
}

async function loadStatistics() {

    document.getElementById("stats")
        .innerHTML =
        "Statistics API Coming Soon";
}
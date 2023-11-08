// HORA ACTUAL

        window.addEventListener('load', function () {
            var now = new Date();
            var hour = now.getHours();
            var minute = now.getMinutes();
            if (hour < 10) hour = '0' + hour;
            if (minute < 10) minute = '0' + minute;
            var time = hour + ':' + minute;
            document.querySelector('input[type="time"]').value = time;
        });

// FECHA ACTUAL

// Obtener la fecha actual
let today = new Date().toLocaleDateString('en-CA', {year: 'numeric', month: '2-digit', day: '2-digit'});
// Establecer la fecha actual como el valor del campo de fecha
document.querySelector("[name=fecha]").value = today;
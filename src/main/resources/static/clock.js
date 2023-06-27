let hour = document.getElementById('hour');
let minute = document.getElementById('minute');
let second = document.getElementById('second');
let msecond = document.getElementById('msecond');
let start = document.getElementById('start');
let stop = document.getElementById('stop');

let timer = false;

start.addEventListener('click', function () {
    timer = true;
    stopwatch();
});

stop.addEventListener('click', function () {
    timer = false;
});

function stopwatch() {
    if (timer) {
        count++;
        if (count == 100) {
            sec++;
            count = 0;
        }

        if (sec == 60) {
            min++;
            sec = 0;
        }

        if (min == 60) {
            hr++;
            min = 0;
            sec = 0;
        }

        let hrString = hr;
        let minString = min;
        let secString = sec;
        let countString = count;

        if (hr < 10) {
            hrString = "0" + hrString;
        }

        if (min < 10) {
            minString = "0" + minString;
        }

        if (sec < 10) {
            secString = "0" + secString;
        }

        if (count < 10) {
            countString = "0" + countString;
        }

        hour.textContent = hrString;
        minute.textContent = minString;
        second.textContent = secString;
        msecond.textContent = countString;

        hour.value = hrString;
        minute.value = minString;
        second.value = secString;
        msecond.value = countString;
        setTimeout(stopwatch, 10);
    }
}
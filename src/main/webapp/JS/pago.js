
const btnCerrar = document.querySelector(".btnCerrar");
const btnComprafinta = document.querySelector(".btnComprafinta")
const tarjetaDiv = document.querySelector(".tarjetaDiv");
console.log(btnCerrar);

btnCerrar.addEventListener('click', () => {
    tarjetaDiv.classList.add("modalNone");
});

btnComprafinta.addEventListener('click', () => {
    tarjetaDiv.classList.remove("modalNone");
})



        function formatCardNumber(input) {
            let value = input.value;
            let numericValue = '';
            for (let i = 0; i < value.length; i++) {
                if (!isNaN(value[i]) && value[i] !== ' ') {
                    numericValue += value[i];
                }
            }

            let formattedValue = '';
            for (let i = 0; i < numericValue.length; i++) {
                if (i > 0 && i % 4 === 0) {
                    formattedValue += ' ';
                }
                formattedValue += numericValue[i];
            }
            input.value = formattedValue;
        }
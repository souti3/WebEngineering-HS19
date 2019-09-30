package mvc

class CalculatorController {

    def calc(double en, double msp) {
        double result = (en + msp) / 2
        // wohin: die View, was: das Model
        render(view: "CalculatorOutput", model: [result: result])
    }
}

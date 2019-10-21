package mvc

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link ControllerUnitTest} for usage instructions.
 */
class InPlaceCalculatorControllerSpec extends Specification implements ControllerUnitTest<InPlaceCalculatorController> {

    void "average of en:5 and exam:6 should be 6"(){
        when:
        def model = new CalculatorModel(en: 5, exam: 6)
        controller.calc(model)
        then:
        model.result == "6"
    }

    @Unroll
    void "average of #en and #exam should be #result"(en, exam, result) {
        when:
            def model = new CalculatorModel(en:en, exam:exam)
            controller.calc(model)
        then: "average calculation"
            model.result == result
        where:
            en  | exam | result
            0.0 | 0.0  | "0"
            1.0 | 2.0  | "2"
            2.0 | 1.0  | "2"
            1.0 | 1.9  | "1"
    }
}

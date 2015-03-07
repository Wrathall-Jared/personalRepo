public class MVCCalculator {
    
    public static void main(String[] args) {
    	
    	// References to views
    	view.MainView mainView = new view.MainView();
    	view.CalculatorView calculationView = new view.CalculatorView();
    	view.NumbersView numbersView = new view.NumbersView();
    	
    	// References to Models
    	model.CalculatorModel theModel = new model.CalculatorModel();
        
    	// References to Controllers
        controller.CalculatorController theController = new controller.CalculatorController(calculationView,theModel);
        
        mainView.add(numbersView);
        mainView.add(calculationView);
        
        mainView.setVisible(true);
        
        
    }
}
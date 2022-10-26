package com.example.BBTG.archieve;

public class Archive1 {

//    public static void findSETs(String[][] temp) {
//
//        //create temp arraylist of all the cardModels
//        List<Card> temp_cards = new ArrayList<>(12);
//
//        //convert 2D arraylist into SETs and add them to temp_sets
//        for (String[] strings : temp) {
//            String amount = strings[0];
//            String color = strings[1];
//            String shape = strings[2];
//            String shading = strings[3];
//
//            temp_cards.add(new Card(Integer.parseInt(amount), color, shape, shading));
//        }
//
//        //create a HashMap of keys (0-11) and values in temp_sets
//        Map<Integer, Card> cardModels = new HashMap<>(12);
//        int count = 0;
//        for (Card card : temp_cards){
//            cardModels.put(count, card);
//            count++;
//        }
//
//        searchForSETs(cardModels);
//    }




//    private TextView cardNumberTextView, questionTextView;
//    private Button ansA, ansB, ansC, goBackButton, restartButton;
//
//    private int currentCard;
//    private int currentQuestionIndex;
//    private int cardParameters = Variant.values().length;
//
//    private String[][] cardArray;
//    private String[] card;
//
//    public void setCurrentCard() {
//        currentCard = 1;
//    }
//
//    public void setCurrentQuestionIndex() {
//        currentQuestionIndex = 0;
//    }
//
//    public void setCardArray() {
//        cardArray = new String[6][4];
//    }
//
//    private void setTemp() {
//        card = new String[4];
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        setValuesAndStart();
//    }
//
//    @Override
//    public void onClick(View v) {
//
//        Button clickedButton = (Button) v;
//
//        String selectedAnswer = clickedButton.getText().toString();
//
//        //put the parameter into an array of parameters for each card
//        card[currentQuestionIndex] = selectedAnswer;
//
//        currentQuestionIndex++;
//
//        if (currentQuestionIndex == cardParameters) {
//
//            //avoid duplicates (check if user has already entered a card with same parameters)
//            boolean isCardAlreadyEntered = false;
//
//            for(String[] arr: cardArray){
//                if(Arrays.equals(arr, card)){
//                    isCardAlreadyEntered = true;
//                    break;
//                }
//            }
//
//            if(!isCardAlreadyEntered){
//                //put current card into the card array
//                cardArray[currentCard-1] = card;
//                toNextCard();
//            }else{
//                //throw a pop-up error
//                throwAlert("Duplicate alert");
//            }
//        }else {
//            loadQuestion(Variant.values()[currentQuestionIndex]);
//        }
//    }
//
//    private void isCardEntered(){
//
//    }
//
//    private boolean validateDuplicates(Card currentCard, List<Card> cardModels){
//        return cardModels.contains(currentCard);
//    }
//
//    public void loadQuestion(Variant variant){
//        setInfo();
//        setText(variant);
//        setButtonsBackgroundColor(variant);
//    }
//
//    private void setText(Variant variant){
//        cardNumberTextView.setText("Current card : " + currentCard);
//        questionTextView.setText(variant.name());
//        ansA.setText(variant.getVariant1());
//        ansB.setText(variant.getVariant2());
//        ansC.setText(variant.getVariant3());
//    }
//
//    private void setButtonsBackgroundColor(Variant variant){
//        if(variant == Variant.Color){
//            ansA.setBackground(getDrawable(R.drawable.red_button));
//            ansB.setBackground(getDrawable(R.drawable.green_button));
//            ansC.setBackground(getDrawable(R.drawable.purple_button));
//        }else{
//            ansA.setBackground(getDrawable(R.drawable.white_button));
//            ansB.setBackground(getDrawable(R.drawable.white_button));
//            ansC.setBackground(getDrawable(R.drawable.white_button));
//        }
//    }
//
//    private void toNextCard() {
//
//        //check whether 12 cardModels were already entered
//        if (Collections.frequency(Arrays.asList(cardArray), null) == 0) {
//
//            Log.i("cardArray", Arrays.deepToString(cardArray));
//
//            SET_Finder.findSETs(cardArray);
//
//            List<List<String>> output = SET_Finder.getOutput();
//            for (List<String> stringList : output) {
//                Log.i("output", String.valueOf(stringList));
//            }
//
//            throwAlert(SET_Finder.getTotalSETsFound());
//
//        }else{
//            card = new String[4];
//            currentQuestionIndex = 0;
//            currentCard++;
//            loadQuestion(Variant.values()[currentQuestionIndex]);
//        }
//    }
//
//    private void throwAlert(int totalSETsFound){
//        switch (totalSETsFound) {
//            case 0:
//                //non SETs were found
//                new AlertDialog.Builder(this, R.style.AlertDialogFail)
//                        .setTitle("non SETs were found")
//                        .setMessage("In your case, where are no SETs at all.")
//                        .setPositiveButton("Restart", (dialogInterface, i) -> restart())
//                        .setCancelable(false)
//                        .show();
//                return;
//
//            case 1:
//                new AlertDialog.Builder(this, R.style.AlertDialogSuccess)
//                        .setTitle(1 + " SET was found")
//                        .setMessage("Want to reveal it?")
//                        .setPositiveButton("Reveal", (dialogInterface, i) ->
//                                showFoundSETs(1))
//                        .setNegativeButton("Restart", (dialogInterface, i) -> restart())
//                        .setCancelable(false)
//                        .show();
//                return;
//
//            default:
//                new AlertDialog.Builder(this, R.style.AlertDialogSuccess)
//                        .setTitle(totalSETsFound + " SETs were found")
//                        .setMessage("Want to reveal them?")
//                        .setPositiveButton("Reveal", (dialogInterface, i) ->
//                                showFoundSETs(totalSETsFound))
//                        .setNegativeButton("Restart", (dialogInterface, i) -> restart())
//                        .setCancelable(false)
//                        .show();
//        }
//    }
//
//    private void throwAlert(String message){
//        if(message.equals("Duplicate alert")){
//            new AlertDialog.Builder(this, R.style.AlertDialogFail)
//                    .setTitle("ERROR: you have already entered this card")
//                    .setMessage("Where are no duplicates in SET")
//                    .setPositiveButton("Restart", (dialogInterface, i) -> restart())
//                    .setNegativeButton("Back", (dialogInterface, i) -> goBack())
//                    .setCancelable(false)
//                    .show();
//        }
//    }
//
//    private void showFoundSETs(int totalSETsFound){
//        Intent intent = new Intent(this, ShowFoundSETs.class);
//        intent.putExtra("totalSETsFound", totalSETsFound);
//
//        int i = SET_Finder.getOutput().size();
//        while(i!=0){
//            intent.putExtra("Set "+String.valueOf(i)+" card1", SET_Finder.getOutput().get(i-1).get(0));
//            intent.putExtra("Set "+String.valueOf(i)+" card2", SET_Finder.getOutput().get(i-1).get(1));
//            intent.putExtra("Set "+String.valueOf(i)+" card3", SET_Finder.getOutput().get(i-1).get(2));
//            i--;
//        }
//
//        startActivity(intent);
//    }
//
//    private void goBack(){
//
//        if(!isGoingBackAvailable()){
//            return;
//        }
//
//        if(currentQuestionIndex == 0){
//            currentQuestionIndex = 3;
//            currentCard--;
//
//            card = cardArray[currentCard-1];
//            card[currentQuestionIndex] = null;
//            cardArray[currentCard-1] = null;
//
//        }else {
//            currentQuestionIndex--;
//            card[currentQuestionIndex] = null;
//        }
//
//        loadQuestion(Variant.values()[currentQuestionIndex]);
//    }
//
//    private boolean isGoingBackAvailable(){
//        if(currentCard == 1 && currentQuestionIndex == 0){
//            return false;
//        }
//        return true;
//    }
//
//    private void setInfo(){
//        cardNumberTextView = findViewById(R.id.card_number);
//        questionTextView = findViewById(R.id.question);
//
//        ansA = findViewById(R.id.answer_A);
//        ansB = findViewById(R.id.answer_B);
//        ansC = findViewById(R.id.answer_C);
//        ansA.setOnClickListener(this);
//        ansB.setOnClickListener(this);
//        ansC.setOnClickListener(this);
//
//        goBackButton = findViewById(R.id.goBackButton);
//        restartButton = findViewById(R.id.restartButton);
//        goBackButton.setOnClickListener(v -> goBack());
//        restartButton.setOnClickListener(v -> restart());
//    }
//
//    private void setValuesAndStart(){
//
//        setCurrentCard();
//        setCurrentQuestionIndex();
//        setCardArray();
//        setTemp();
//
//        SET_Finder.clear_output();
//        SET_Finder.reset_TotalSETsFound();
//
//        loadQuestion(Variant.Amount);
//    }
//
//    private void restart(){
//        setValuesAndStart();
//    }
}
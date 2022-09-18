package com.example.wordleproject

object FourLetterWordList {
    // List of plant names four words: https://bestforpuzzles.com/lists/plants/4.html
    val fourLetterWords =
        "Alfa,Alga,Aloe,Anil,Arum,Bean,Beet,Bent,Bigg,Coca,Cole,Corn,Dill,Diss,Dock,Doob,Fern,Flag,Flax,Gale,Hemp,Herb,Ilex,Irid,Iris,Jute,Kail,Kale,Kali,Kans,Kelp,Leek,Ling,Mate,Mint,Mold,Moss,Muka,Nabk,Oats,Okra,Peat,Pipi,Poke,Race,Ragi,Rami,Rape,Reed,Rhea,Rice,Root,Rush,Rust,Ruta,Sage,Smut,Sola,Tara,Tare,Taro,Teff,Thea,Tree,Tule,Tutu,Ulex,Vine,Wald,Weed,Weld,Whin,Woad,Wort"

    // Returns a list of four letter words as a list
    fun getAllFourLetterWords(): List<String> {
        return fourLetterWords.split(",")
    }

    // Returns a random four letter word from the list in all caps
    fun getRandomFourLetterWord(): String {
        val allWords = getAllFourLetterWords()
        val randomNumber = (0..allWords.size).shuffled().last()
        return allWords[randomNumber].uppercase()
    }
}
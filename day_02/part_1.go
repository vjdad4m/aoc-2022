package main

import (
	"fmt"
	"os"
	"strings"
)

func main() {
	b, err := os.ReadFile("input.txt")

	if err != nil {
		fmt.Print(err)
	}

	data := strings.Split(string(b), "\n")
	
	score := 0

	for i := 0; i < len(data) - 1; i++ {
		current := strings.Split(data[i], " ")
		f := current[0]
		s := current[1]

		if f == "A" {
			if s == "X" {
				// Draw
				score += 3 + 1
			} else if s == "Y" {
				// Win
				score += 6 + 2
			} else {
				// Lose
				score += 0 + 3
			}
		} else if f == "B" {
			if s == "X" {
				// Lose
				score += 0 + 1
			} else if s == "Y" {
				// Draw
				score += 3 + 2
			} else {
				// Win
				score += 6 + 3
			}
		} else {
			if s == "X" {
				// Win
				score += 6 + 1
			} else if s == "Y" {
				// Lose
				score += 0 + 2
			} else {
				// Draw
				score += 3 + 3
			}
		}
	}

	fmt.Println(score)
	
}

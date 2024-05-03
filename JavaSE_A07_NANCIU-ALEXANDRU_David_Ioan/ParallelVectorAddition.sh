#!/bin/bash

# Function to find the project directory
find_project_directory() {
    local dir="$1"
    local target_dir="JavaSE_A07_NANCIU-ALEXANDRU_David_Ioan"

    found_dir=$(find "$dir" -type d -name "$target_dir" -print -quit)

    if [ -n "$found_dir" ]; then
        echo "$found_dir"
    else
        echo "Error: $target_dir directory not found"
        exit 1
    fi
}

# Navigate to parent directory
cd ..

# Find the project directory
project_dir=$(find_project_directory "$(pwd)")

# Navigate to the project directory
cd "$project_dir"

# Compile the Java file
javac -cp src/main/java -d target/classes src/main/java/org/example/ParallelVectorAdditionBenchmark.java

# Check if compilation was successful
if [ $? -eq 0 ]; then
    echo "Compilation successful"

    # Run the Java program
    java -cp target/classes org.example.ParallelVectorAdditionBenchmark
else
    echo "Compilation failed"
fi

export interface CapPrintPlugin {
    echo(options: {
        value: string;
    }): Promise<{
        value: string;
    }>;
    print(): void;
}
